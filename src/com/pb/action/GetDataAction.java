package com.pb.action;

import com.pb.base.action.BaseAction;
import com.pb.dao.HouseDao;
import com.pb.dao.impl.HouseDaoImpl;
import com.pb.entity.District;
import com.pb.entity.HouseType;
import com.pb.entity.Street;

import java.util.*;

/**
 *获取房型信息列表，城区街道信息
 */
public class GetDataAction extends BaseAction {
    private HouseDao houseDao = new HouseDaoImpl();
    private List<HouseType> typeList;
    private List<District> disList;
    private Map<Integer,Set<Street>> streetMap;
    public String findData() {
        typeList = new ArrayList<HouseType>();
        List<Object> houseTypes = houseDao.findAll(HouseType.class);
        for (Object obj : houseTypes) {
            HouseType houseType = (HouseType) obj;
            typeList.add(houseType);
        }
        /** 生成级联选择菜单*/
        streetMap = new HashMap<>();
        disList = new ArrayList<District>();
        List<Object> districts = houseDao.findAll(District.class);
        for (Object obj : districts) {
            District district = (District) obj;
            streetMap.put(district.getId(), (Set<Street>) district.getStreets());
            disList.add(district);
        }
        return SUCCESS;
    }

    public List<District> getDisList() {
        return disList;
    }

    public void setDisList(List<District> disList) {
        this.disList = disList;
    }


    public List<HouseType> getTypeList() {
        return typeList;
    }

    public void setTypeList(List<HouseType> typeList) {
        this.typeList = typeList;
    }

    public Map<Integer, Set<Street>> getStreetMap() {
        return streetMap;
    }

    public void setStreetMap(Map<Integer, Set<Street>> streetMap) {
        this.streetMap = streetMap;
    }
}
