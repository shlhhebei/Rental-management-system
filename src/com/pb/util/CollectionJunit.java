package com.pb.util;

import java.util.EnumMap;
import java.util.EnumSet;

/**
 *此类是为了学习枚举类型所建，跟项目没有关系
 */
public enum CollectionJunit {
    // 利用构造函数传参
    RED("红色"),GREEN("绿色"),YELLOW("黄色");
    //定义私有变量
    private String  code;
    // 构造函数，枚举类型只能为私有
    private CollectionJunit(String _code){
        this.code = _code;
    }

    //覆写toString 方法，在该方法中返回从构造函数中传入的参数
    @Override
    public String toString() {
        return String.valueOf(code);
    }
}
class EnumTest{
    /**
     * 演示枚举类型的遍历
     */
    private static void testTraversalEnum() {
        //values()方法返回一个包含枚举常量列表的数组(所有枚举都自动包含两个预定义方法：values()和valueOf())
        CollectionJunit[] collectionJunits = CollectionJunit.values ();
        for (CollectionJunit collectionJunit : collectionJunits) {
            System. out .println( " 枚举常量的名称 ： " + collectionJunit.name());
            System. out .println( " 举常量的序数 ： " + collectionJunit.ordinal());
            System. out .println( " 当前灯： " + collectionJunit);
        }
    }
    /**
     * 演示 EnumMap 的使用， EnumMap 跟 HashMap 的使用差不多，只不过 key 要是枚举类型
     */
    private static void testEnumMap() {
        // 1. 演示定义 EnumMap 对象， EnumMap 对象的构造函数需要参数传入 , 默认是 key 的类的类型
        EnumMap<CollectionJunit, String> currEnumMap = new EnumMap<CollectionJunit, String>(
                CollectionJunit. class );
        currEnumMap.put(CollectionJunit. RED , " 红灯停 " );
        currEnumMap.put(CollectionJunit. GREEN , " 绿灯行 " );
        currEnumMap.put(CollectionJunit. YELLOW , " 黄灯等 " );
        // 2. 遍历对象
        for (CollectionJunit collectionJunit : CollectionJunit.values ()) {
            System. out .println( "[key=" + collectionJunit.name() + ",value="
                    + currEnumMap.get(collectionJunit) + "]" );
        }
    }
    /**
     * 演示 EnumSet 如何使用， EnumSet 是一个抽象类，获取一个类型的枚举类型内容 <BR/>
     * 可以使用 allOf 方法: 创建一个包含指定元素类型的所有元素的枚举 set
     */
    private static void testEnumSet() {
        EnumSet<CollectionJunit> currEnumSet = EnumSet.allOf(CollectionJunit.class);
        for (CollectionJunit aLightSetElement : currEnumSet) {
            System. out .println( " 当前 EnumSet 中数据为： " + aLightSetElement);
        }
    }

    public static void main(String[] args) {
        //1.遍历枚举类型
        System.out.println(" 演示枚举类型的遍历 ......");
        testTraversalEnum();
        //valueOf()方法获取与枚举常量名称对应的枚举值的方式
        System.out.println(CollectionJunit.valueOf("RED"));

        // 2. 演示 EnumMap 对象的使用
        System. out .println( " 演示 EnmuMap 对象的使用和遍历 ....." );
        testEnumMap ();

        // 3. 演示 EnmuSet 的使用
        System. out .println( " 演示 EnmuSet 对象的使用和遍历 ....." );
        testEnumSet ();
    }
}
