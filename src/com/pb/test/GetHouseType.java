package com.pb.test;

import com.pb.dao.HouseDao;
import com.pb.dao.impl.HouseDaoImpl;
import com.pb.entity.HouseType;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class GetHouseType {
    private HouseDao houseDao = new HouseDaoImpl();
    public List<HouseType> find(){
        List<HouseType> typeList = new ArrayList();
        List<Object> houseTypes = houseDao.findAll(HouseType.class);
        for (Object obj : houseTypes) {
            HouseType houseType = (HouseType) obj;
            typeList.add(houseType);
        }
        return typeList;

    }

}
