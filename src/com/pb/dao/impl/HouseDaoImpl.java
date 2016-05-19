package com.pb.dao.impl;

import com.pb.base.dao.impl.BaseDaoImpl;
import com.pb.dao.HouseDao;
import com.pb.entity.House;
import com.pb.entity.HousePicture;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *关键点：字符串提取数字，hql语句拼接 ，使用 between A and B 时，必须A<B，否则不起作用
 */
public class HouseDaoImpl extends BaseDaoImpl<House> implements HouseDao {

    /**
     * 根据houseId获取房屋图片对象
     * @param id 房屋id
     */
    @Override
    public HousePicture getPictureById(Integer id) {
        House house = (House) findById(House.class, id);
        return house.getPicture();
    }

    /**
     * 查询所有房屋列表
     * @param params Map类型的参数
     */
    @Override
    public Object[] findAll(Map<String, Object> params) {
        //字符串过滤，提取字符串中的数字（关键：0-9几个阿拉伯数字的char值是48-57，使用str.charAt(index)方法返回的值判断该字符是不是数字）
        String price = (String) params.get("价格");
        price.trim();//去除前后空格
        String price1 = "";
        String price2 = "";
        if (price!=null&&!"".equals(price)) {
            int j = 0;
            for (int i = j; i < price.length(); i++) {
                if (price.charAt(i) <= 57 && price.charAt(i) >= 48) {
                    price1 +=price.charAt(i);
                }
                if (j>0&&(price.charAt(i)>57||price.charAt(i)<48)){
                    continue;
                }
                if (i>2&&(price.charAt(i)>57||price.charAt(i)<48)){
                    j=i;
                    price2 = price1;
                    price1 = "";
                    continue;
                }
            }
        }
        if (Integer.parseInt(price1) < Integer.parseInt(price2)){
            String middle = price1;
            price1 = price2;
            price2 = middle;
        }

        if (price.contains(">")&& !price.contains("<")){
            price2="100000000";
        }
        String floorage = (String) params.get("面积");
        floorage.trim();
        String floorage1 = "";
        String floorage2 = "";
        if (floorage != null && !"".equals(floorage)) {
            int j = 0;
            for (int i = j; i < floorage.length(); i++) {
                if (floorage.charAt(i) <= 57 && floorage.charAt(i) >= 48) {
                    floorage1 +=floorage.charAt(i);
                }
                if (j>0&&(floorage.charAt(i)>57||floorage.charAt(i)<48)){
                    continue;
                }
                if (i>2&&(floorage.charAt(i)>57||floorage.charAt(i)<48)){
                    j=i;
                    floorage2 = floorage1;
                    floorage1 = "";
                    continue;
                }
            }
        }
        if (floorage.contains(">")&& !floorage.contains("<")){
            floorage2="100000000";
        }
        if (Integer.parseInt(floorage1) < Integer.parseInt(floorage2)){
            String middle = floorage1;
            floorage1 = floorage2;
            floorage2 = middle;
        }
        //hql查询是查一个表，关联其他表，sql是查所有相关表 才能得到每个表的信息
        String hql = "from House h where h.title like '%"
                + params.get("标题") + "%' and (h.price between "+price2+" and "+price1
                + ") and (h.floorage between "+floorage2+" and "+floorage1
                + ") and h.houseType.name='"
                + params.get("房型") + "' and h.street.name='"
                + params.get("房屋位置") + "'";
        List list = findByHql(hql);
        return list.toArray();
    }
    @Test
    public void test() {
        Map map = new HashMap();
        map.put("标题","好房出租");
        map.put("价格",">100,<3000");
        map.put("房型","一室一厅");
        map.put("面积",">10,<1000");
        map.put("房屋位置","知春路");
        Object[] objects = findAll(map);
        for (int i = 0; i < objects.length; i++) {
            House house = (House) objects[i];
            System.out.println(house.getId()+"::"+house.getTitle()+"::"+house.getPrice()+"::"+house.getFloorage()+"::"+house.getHouseType().getName()+"::"+house.getStreet().getName());
        }
    }
}
