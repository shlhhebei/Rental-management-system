package com.pb.entity;

import java.util.HashSet;
import java.util.Set;

public class District implements java.io.Serializable {

	// Fields
	private Integer id;
	private String name;
	private Set<Street> streets = new HashSet<Street>(0);

	// Constructors
	/** default constructor */
	public District() {
	}

	/** minimal constructor */
	public District(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	/** full constructor */
	public District(Integer id, String name, Set<Street> streets) {
		this.id = id;
		this.name = name;
		this.streets = streets;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Street> getStreets() {
		return this.streets;
	}

	public void setStreets(Set<Street> streets) {
		this.streets = streets;
	}

}