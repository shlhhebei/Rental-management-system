package com.pb.service.impl;


import com.pb.dao.HouseDao;
import com.pb.dao.impl.HouseDaoImpl;
import com.pb.entity.*;
import com.pb.service.IHouseService;
import com.pb.util.UpLoadFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 */
public class IHouseServiceImpl implements IHouseService {
    private HouseDao houseDao = new HouseDaoImpl();

    /**
     * 保存房屋
     * @param house 从页面传来的房屋信息
     */
    @Override
    public boolean save(House house, UpLoadFile file) {
        houseDao.save(house);
        return false;
    }

    /**
     * 删除房屋
     * @param house 从页面传来的房屋信息
     */
    @Override
    public void delete(House house) {
        houseDao.delete(house);
    }

    /**
     * 修改房屋
     * @param house 从页面传来的房屋信息
     */
    @Override
    public boolean update(House house, UpLoadFile file) {
        houseDao.update(house);
        return false;
    }

    /**
     * 根据Id获取房屋
     * @param id int类型的参数
     */
    @Override
    public House findById(Integer id) {
        House house = (House) houseDao.findById(House.class, id);
        return house;
    }

    /**
     * 根据houseId获取房屋图片对象
     * @param id 房屋id
     */
    @Override
    public HousePicture getPictureById(Integer id) {
        return houseDao.getPictureById(id);
    }

    /**
     * 查询所有房屋列表
     * @param params Map类型的参数
     */
    @Override
    public Object[] findAll(Map<String, Object> params) {
        return houseDao.findAll(params);
    }

    /**
     * 查询所有房屋类型列表
     */
    @Override
    public List<HouseType> findTypeList() {
        List l = houseDao.findAll(HouseType.class);
        return l;
    }

    /**
     * 查询所有区列表
     */
    @Override
    public List<District> findDistrictList() {
        List l = houseDao.findAll(District.class);
        return l;
    }

    /**
     * 根据区id查询所有街道列表
     */
    @Override
    public List<Street> findStreetListByDisId(int disId) {
        List<Street> list = new ArrayList<Street>();
        District district = (District) houseDao.findById(District.class, disId);
        for (Object street : district.getStreets()) {
            list.add((Street) street);
        }
        return list;
    }

    /** getters and setters*/
    public HouseDao getHouseDao() {
        return houseDao;
    }

    public void setHouseDao(HouseDao houseDao) {
        this.houseDao = houseDao;
    }
}
