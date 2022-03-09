package com.tanmay.Liv2Train.models;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.tanmay.Liv2Train.dto.Address;

@Document(collection = "center")
public class Center {
	@Id
    private String id;
	private String centerName;
	private String centerCode;
	private Address address;
	private String studentCapacity;
	private List<String > coursesOffered;
	private long createdOn;
	private String contactEmail;
	private String contactPhone;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getCenterName() {
		return centerName;
	}
	public void setCenterName(String centerName) {
		this.centerName = centerName;
	}
	public String getCenterCode() {
		return centerCode;
	}
	public void setCenterCode(String centerCode) {
		this.centerCode = centerCode;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public String getStudentCapacity() {
		return studentCapacity;
	}
	public void setStudentCapacity(String studentCapacity) {
		this.studentCapacity = studentCapacity;
	}
	
	public List<String> getCoursesOffered() {
		return coursesOffered;
	}
	public void setCoursesOffered(List<String> coursesOffered) {
		this.coursesOffered = coursesOffered;
	}
	public String getContactEmail() {
		return contactEmail;
	}
	
	
	public long getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(long createdOn) {
		this.createdOn = createdOn;
	}
	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}
	public String getContactPhone() {
		return contactPhone;
	}
	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}
	
	
}
