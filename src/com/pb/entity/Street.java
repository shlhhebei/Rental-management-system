package com.pb.entity;

public class Street implements java.io.Serializable {

	// Fields
	private Integer id;
	private String name;

	private District district;

	// Constructors
	/** default constructor */
	public Street() {
	}

	/** minimal constructor */
	public Street(Integer id, String name, District district) {
		super();
		this.id = id;
		this.name = name;
		this.district = district;
	}

	public Street(Integer id) {
		this.id = id;
	}

	/** full constructor */
	// Property accessors
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public District getDistrict() {
		return this.district;
	}

	public void setDistrict(District district) {
		this.district = district;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Street{" +
				"district=" + district +
				", id=" + id +
				", name='" + name + '\'' +
				'}';
	}
}