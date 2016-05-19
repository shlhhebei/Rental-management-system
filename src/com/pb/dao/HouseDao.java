package com.pb.dao;

import com.pb.base.dao.IBaseDao;
import com.pb.entity.House;
import com.pb.entity.HousePicture;

import java.util.Map;

/**
 *房屋查询炒作接口
 */
public interface HouseDao extends IBaseDao<House> {

    /**
     * 根据houseId获取房屋图片对象
     * @param id 房屋id
     */
    HousePicture getPictureById(Integer id);
    /**
     * 查询所有房屋列表
     * @param params Map类型的参数
     */
    Object[] findAll(Map<String,Object> params);

}
