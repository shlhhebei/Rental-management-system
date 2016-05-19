package com.pb.entity;

import java.util.Date;

public class House implements java.io.Serializable {

	// Fields
	private Integer id;
	private String title; //标题
	private String description; //描述
	private Double price; //价格
	private Date pubdate; //房产证日期
	private Date adddate; //发布日期
	private Double floorage; //面积
	private String contact; //联系电话

	private HouseUser houseUser;
	private HouseType houseType; //房型
	private Street street; //位置
	private HousePicture picture;
//	private Set<HousePicture> pictures;
	
	// Constructors
	/** default constructor */
	public House() {
	}

	/** minimal constructor */
	public House(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public House(Integer id, HouseUser houseUser, HouseType houseType,
			Street street, String title, String description, Double price,
			Date pubdate, Date adddate, Double floorage, String contact/*,
			Set<HousePicture> housePictures*/) {
		this.id = id;
		//this.houseUser = houseUser;
		//this.houseType = houseType;
		//this.street = street;
		this.title = title;
		this.description = description;
		this.price = price;
		this.pubdate = pubdate;
		this.adddate = adddate;
		this.floorage = floorage;
		this.contact = contact;
		//this.housePictures = housePictures;
	}

	/**  setters and getters  */
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public HouseUser getHouseUser() {
		return this.houseUser;
	}

	public void setHouseUser(HouseUser houseUser) {
		this.houseUser = houseUser;
	}

	public HouseType getHouseType() {
		return this.houseType;
	}

	public void setHouseType(HouseType houseType) {
		this.houseType = houseType;
	}

	public Street getStreet() {
		return this.street;
	}

	public void setStreet(Street street) {
		this.street = street;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Date getPubdate() {
		return this.pubdate;
	}

	public void setPubdate(Date pubdate) {
		this.pubdate = pubdate;
	}

	public Date getAdddate() {
		return this.adddate;
	}

	public void setAdddate(Date adddate) {
		this.adddate = adddate;
	}

	public Double getFloorage() {
		return this.floorage;
	}

	public void setFloorage(Double floorage) {
		this.floorage = floorage;
	}

	public String getContact() {
		return this.contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public HousePicture getPicture() {
		return picture;
	}

	public void setPicture(HousePicture picture) {
		this.picture = picture;
	}

	/*public Set<HousePicture> getHousePictures() {
		return this.housePictures;
	}

	public void setHousePictures(Set<HousePicture> housePictures) {
		this.housePictures = housePictures;
	}*/

}