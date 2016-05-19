package com.pb.entity;


public class HouseUser implements java.io.Serializable {

	// Fields
	private Integer id;
	private String password;
	private String telephone;
	private String username;
	private String isadmin;
	private String realname;

	// Constructors
	/** default constructor */
	public HouseUser() {
	}

	/** minimal constructor */
	public HouseUser(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public HouseUser(Integer id, String password, String telephone,
			String username, String isadmin, String realname) {
		this.id = id;
		this.password = password;
		this.telephone = telephone;
		this.username = username;
		this.isadmin = isadmin;
		this.realname = realname;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getIsadmin() {
		return this.isadmin;
	}

	public void setIsadmin(String isadmin) {
		this.isadmin = isadmin;
	}

	public String getRealname() {
		return this.realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	@Override
	public String toString() {
		return "HouseUser{" +
				"id=" + id +
				", password='" + password + '\'' +
				", telephone='" + telephone + '\'' +
				", username='" + username + '\'' +
				", isadmin='" + isadmin + '\'' +
				", realname='" + realname + '\'' +
				'}';
	}
}