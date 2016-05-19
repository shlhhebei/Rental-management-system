package com.pb.test;

import com.pb.entity.House;
import com.pb.util.HibernateSessionFactory;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.Iterator;
import java.util.List;

/**
 *
 */
public class TestHibernate {
    public static void main(String[] args) {
        House house = new House();

        Session session = HibernateSessionFactory.getSession();

        String hql = "from House h where " +
                "h.title like '%好房出租%' and(h.price between 10000 and 10) and(h.floorage between 10 and 1000) and h.houseType.name='一室一厅' and h.street.name='知春路'";
        Query query = session.createQuery(hql);
        List list = query.list();
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            House house1 = (House) iterator.next();
            System.out.println(house1.getHouseType().getName());
        }
        /*House house1 = (House) session.get(House.class, 1);
        System.out.println(house1.getHouseType().getName()+house1.getStreet().getName()+house1.getStreet().getDistrict().getName());*/
    }
}
