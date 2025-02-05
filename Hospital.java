package com.java.hospital;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Hospitalnew")
public class Hospital {
	@Id
	@Column(name = "hospitalid")
	private String hospitalid;
	@Column(name = "hospitalname")
	private String hospitalname;
	@Column(name = "city")
	private String city;
	@Column(name = "streetname")
	private String streetname;
	@Column(name = "zipcode")
	private String zipcode;
	@Column(name = "email")
	private String email;
	@Column(name = "phoneno")
	private String phoneno;
	public String getHospitalid() {
		return hospitalid;
	}
	public void setHospitalid(String hospitalid) {
		this.hospitalid = hospitalid;
	}
	public String getHospitalname() {
		return hospitalname;
	}
	public void setHospitalname(String hospitalname) {
		this.hospitalname = hospitalname;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getStreetname() {
		return streetname;
	}
	public void setStreetname(String streetname) {
		this.streetname = streetname;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneno() {
		return phoneno;
	}
	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}
	@Override
	public String toString() {
		return "Hospital [hospitalid=" + hospitalid + ", hospitalname=" + hospitalname + ", city=" + city
				+ ", streetname=" + streetname + ", zipcode=" + zipcode + ", email=" + email + ", phoneno=" + phoneno
				+ "]";
	}
	public Hospital(String hospitalid, String hospitalname, String city, String streetname, String zipcode,
			String email, String phoneno) {
		super();
		this.hospitalid = hospitalid;
		this.hospitalname = hospitalname;
		this.city = city;
		this.streetname = streetname;
		this.zipcode = zipcode;
		this.email = email;
		this.phoneno = phoneno;
	}
	public Hospital() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
