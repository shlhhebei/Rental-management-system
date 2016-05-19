package com.pb.service;

import com.pb.entity.*;
import com.pb.util.UpLoadFile;

import java.util.List;
import java.util.Map;

public interface IHouseService {

	/**
	 * 保存房屋
	 * @param house 从页面传来的房屋信息
	 */
	boolean save(House house, UpLoadFile file);

	/**
	 * 删除房屋
	 * @param house 从页面传来的房屋信息
	 */
	void delete(House house);

	/**
	 * 修改房屋
	 * @param house 从页面传来的房屋信息
	 */
	boolean update(House house, UpLoadFile file);

	/**
	 * 根据Id获取房屋
	 * @param id int类型的参数
	 */
	House findById(Integer id);

	/**
	 * 根据houseId获取房屋图片对象
	 * @param id 房屋id
	 */
	HousePicture getPictureById(Integer id);
	
	/**
	 * 查询所有房屋列表
	 * @param params Map类型的参数
	 */
	Object[] findAll(Map<String, Object> params);
	
	/**
	 * 查询所有房屋类型列表
	 */
	List<HouseType> findTypeList();
	
	/**
	 * 查询所有区列表
	 */
	List<District> findDistrictList();

	/**
	 * 根据区id查询所有街道列表
	 */
	List<Street> findStreetListByDisId(int disId);

}
