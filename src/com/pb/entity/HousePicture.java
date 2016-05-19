package com.pb.entity;

/**
 * HousePicture entity. @author MyEclipse Persistence Tools
 */

public class HousePicture implements java.io.Serializable {

	// Fields
	private Integer id;
	private String title;
	private Integer houseId;
	private String url;

	// Constructors
	/** default constructor */
	public HousePicture() {
	}

	/** minimal constructor */
	public HousePicture(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public HousePicture(Integer id, String title, String url) {
		this.id = id;
		this.title = title;
		this.url = url;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getHouseId() {
		return houseId;
	}

	public void setHouseId(Integer houseId) {
		this.houseId = houseId;
	}


}