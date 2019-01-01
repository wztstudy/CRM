package com.cc.model;

public class User{
	
	private String themeColor;
	
	private Integer roleID;
	
	private String section;
	
	private String role;

	private Integer id;

	private String name;

	private String username;
	
	private String password;

	private String mobile;

	private Integer sex;

	private String address;

	private Integer age;

	private Integer status;

	private Integer sectionID;

	private String lockingTime;

	public String getThemeColor() {
		return themeColor;
	}

	public void setThemeColor(String themeColor) {
		this.themeColor = themeColor;
	}

	public Integer getRoleID() {
		return roleID;
	}

	public void setRoleID(Integer roleID) {
		this.roleID = roleID;
	}

	public Integer getId(){
		 return id;
	}

	public void setId(Integer id){
		 this.id= id;
	}

	public String getName(){
		 return name;
	}

	public void setName(String name){
		 this.name= name;
	}

	public String getUsername(){
		 return username;
	}

	public void setUsername(String username){
		 this.username= username;
	}
	
	public String getPassword(){
		 return password;
	}

	public void setPassword(String password){
		 this.password= password;
	}

	public String getMobile(){
		 return mobile;
	}

	public void setMobile(String mobile){
		 this.mobile= mobile;
	}

	public Integer getSex(){
		 return sex;
	}

	public void setSex(Integer sex){
		 this.sex= sex;
	}

	public String getAddress(){
		 return address;
	}

	public void setAddress(String address){
		 this.address= address;
	}

	public Integer getAge(){
		 return age;
	}

	public void setAge(Integer age){
		 this.age= age;
	}

	public Integer getStatus(){
		 return status ;
	}

	public void setStatus(Integer status){
		 this.status= status;
	}

	public Integer getSectionID(){
		 return sectionID;
	}

	public void setSectionID(Integer sectionID){
		 this.sectionID= sectionID;
	}

	public String getLockingTime(){
		 return lockingTime;
	}

	public void setLockingTime(String lockingTime){
		 this.lockingTime= lockingTime;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Integer getRoleid() {
		return roleID;
	}

	public void setRoleid(Integer roleid) {
		this.roleID = roleid;
	}

	@Override
	public String toString() {
		return "User [section=" + section + ", role=" + role + ", id=" + id + ", name=" + name + ", username="
				+ username + ", password=" + password + ", mobile=" + mobile + ", sex=" + sex + ", address=" + address
				+ ", age=" + age + ", status=" + status + ", sectionID=" + sectionID + ", lockingTime=" + lockingTime
				+ "]";
	}

}