package com.pb.util;

import java.util.HashMap;
import java.util.Map;

public abstract  class Constant {
	
	public static int PAGE_START = 0;// 默认起始页
	public static int PAGE_COUNT = 3;// 默认每页记录数
	public static String LOGIN_USER = "LOGIN_USER";// 登录用户
	public static String UPLOAD_PATH = "/upload";// 默认上传文件目录
	public static Map<String,String> getPrice() {
		Map<String, String> map = new HashMap<>();
		map.put("<=1000","1000元及以下");
		map.put(">1000,<2000", "1000元—2000元");
		map.put(">=2000", "2000元及以上");
		return map;
	}
	public static Map<String,String> getFloorage() {
		Map<String, String> map = new HashMap<>();
		map.put("<=40","40及以下");
		map.put(">40,<80", "40—8");
		map.put(">=80", "80及以上");
		return map;
	}
}
