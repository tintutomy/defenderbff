package com.gov.hack.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class VolunteerProfile  {
	private String firstName;
	private String lasttName;
	private int mobileNumber;
	private String address;
	private String postcode;
	private boolean availability;
	private String category;
	@Id
	@GeneratedValue
	private int voluteerId;
	public int getVoluteerId() {
		return voluteerId;
	}
	public void setVoluteerId(int voluteerId) {
		this.voluteerId = voluteerId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLasttName() {
		return lasttName;
	}
	public void setLasttName(String lasttName) {
		this.lasttName = lasttName;
	}
	public int getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(int mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	public boolean isAvailability() {
		return availability;
	}
	public void setAvailability(boolean availability) {
		this.availability = availability;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
}
