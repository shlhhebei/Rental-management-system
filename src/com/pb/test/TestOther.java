package com.pb.test;

import com.pb.entity.House;

/**
 * Created by lenovo on 2016/5/12.
 */
public class TestOther {
    public static void main(String[] args) {
        String price = "<1000,>500";
        price.trim();
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
        System.out.println("price1:"+price1);
        System.out.println("price2:"+price2);
        System.out.println(price.contains("="));
        System.out.println(House.class.toString());
    }
}
