package com.java.hospital;

import java.sql.SQLException;
import java.util.List;

public interface DoctorDao {
	String addDoctor(Doctor ed) throws ClassNotFoundException, SQLException;
	List<Doctor> showDoctors()throws ClassNotFoundException, SQLException;
	List<Doctor> searchAvailableSlot(Doctor ed) throws ClassNotFoundException, SQLException;

}
