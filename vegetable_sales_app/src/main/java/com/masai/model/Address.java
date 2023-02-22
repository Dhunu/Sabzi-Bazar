package com.masai.model;

public class Address {

	private Integer flatNo;
	private String buildingName;
	private String area;
	private String city;
	private String state;
	private String pincode;

	public Address() {

	}

	public Address(Integer flatNo, String buildingName, String area, String city, String state, String pincode) {
		super();
		this.flatNo = flatNo;
		this.buildingName = buildingName;
		this.area = area;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
	}

	public Integer getFlatNo() {
		return flatNo;
	}

	public void setFlatNo(Integer flatNo) {
		this.flatNo = flatNo;
	}

	public String getBuildingName() {
		return buildingName;
	}

	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	@Override
	public String toString() {
		return "Address [flatNo=" + flatNo + ", buildingName=" + buildingName + ", area=" + area + ", city=" + city
				+ ", state=" + state + ", pincode=" + pincode + "]";
	}

}
