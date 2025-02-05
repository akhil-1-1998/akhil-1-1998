package com.java.hospital;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

public class Doctor {
	public enum AvailableSlot {
        GENERAL,
        MORNING,
        EVENING,
        WEEKENDS,
        CALLON;
    }
	@Id
	private String doctorid;
	private String doctorname;
	private String specialization;
	private String qualification;
	@Enumerated(EnumType.STRING)
	private AvailableSlot availableslot;
	public String getDoctorid() {
		return doctorid;
	}
	public void setDoctorid(String doctorid) {
		this.doctorid = doctorid;
	}
	public String getDoctorname() {
		return doctorname;
	}
	public void setDoctorname(String doctorname) {
		this.doctorname = doctorname;
	}
	public String getSpecialization() {
		return specialization;
	}
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public AvailableSlot getAvailableslot() {
		return availableslot;
	}
	public void setAvailableslot(AvailableSlot availableslot) {
		this.availableslot = availableslot;
	}
	public Doctor(String doctorid, String doctorname, String specialization, String qualification,
			AvailableSlot availableslot) {
		super();
		this.doctorid = doctorid;
		this.doctorname = doctorname;
		this.specialization = specialization;
		this.qualification = qualification;
		this.availableslot = availableslot;
	}
	@Override
	public String toString() {
		return "Doctor [doctorid=" + doctorid + ", doctorname=" + doctorname + ", specialization=" + specialization
				+ ", qualification=" + qualification + ", availableslot=" + availableslot + "]";
	}
	public Doctor() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
