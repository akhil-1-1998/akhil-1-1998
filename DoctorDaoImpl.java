package com.java.hospital;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DoctorDaoImpl implements DoctorDao{
	static Connection con;
	static PreparedStatement pst;
	
	public static String getDoctorId() throws SQLException, ClassNotFoundException {
        String query = "SELECT DoctorId FROM doctor d1 WHERE (SELECT COUNT(distinct DoctorId)FROM doctor d2 WHERE d1.DoctorId<d2.DoctorId)=0";
        con=ConnectionHelper.getconnection();
        String check = null;
		pst=con.prepareStatement(query);
		ResultSet rs = pst.executeQuery();
		
		if (rs.next()) {
            String lastId = rs.getString("DoctorId");
            int sum=Integer.parseInt(lastId.substring(1,5));
            sum=sum+1;
            
           if(sum<=9) {
            	check="D000"+sum;
            }
            else if(sum==10||sum<=99) {
            	check="D00"+sum;
            }
            else if(sum==100||sum<=999) {
            	check="D0"+sum;
            }
            else {
            	check="D"+sum;
            }
		}
		return check;
            
    }

	@Override
	public String addDoctor(Doctor ed) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		String doctorid=getDoctorId();
		ed.setDoctorid(doctorid);
		String add="insert into doctor (DoctorId, DoctorName, Specialization, Qualification, AvailableSlot) values(?,?,?,?,?)";
		con=ConnectionHelper.getconnection();
		pst=con.prepareStatement(add);
		pst.setString(1,ed.getDoctorid());
		pst.setString(2,ed.getDoctorname());
		pst.setString(3,ed.getSpecialization());
		pst.setString(4,ed.getQualification());
		pst.setString(5,ed.getAvailableslot().name());
		pst.executeUpdate();
		return "**add details**";
	}

	@Override
	public List<Doctor> showDoctors() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		con=ConnectionHelper.getconnection();
		String list="select * from doctor";
		pst=con.prepareStatement(list);
		ResultSet rs=pst.executeQuery();
		Doctor ed=null;
		List<Doctor> docList=new ArrayList<>();
		while(rs.next()) {
			ed=new Doctor();
			ed.setDoctorid(rs.getString("doctorid"));
			ed.setDoctorname(rs.getString("doctorname"));
			ed.setSpecialization(rs.getString("specialization"));
			ed.setQualification(rs.getString("qualification"));
			ed.setAvailableslot(Doctor.AvailableSlot.valueOf(rs.getString("availableslot")));
			docList.add(ed);	
		}
		return docList;
	}

	@Override
	public List<Doctor> searchAvailableSlot(Doctor ed) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		String availableslotlist="select * from doctor where availableslot = ?";
		con=ConnectionHelper.getconnection();
		pst=con.prepareStatement(availableslotlist);
		pst.setString(1,ed.getAvailableslot().name());
		ResultSet rs=pst.executeQuery();
		Doctor ed1=null;
		List<Doctor> docList=new ArrayList<>();
		while(rs.next()) {
			ed1=new Doctor();
			ed1.setDoctorid(rs.getString("doctorid"));
			ed1.setDoctorname(rs.getString("doctorname"));
			ed1.setSpecialization(rs.getString("specialization"));
			ed1.setQualification(rs.getString("qualification"));
			ed1.setAvailableslot(Doctor.AvailableSlot.valueOf(rs.getString("availableslot")));
			docList.add(ed1);	
		}
		
		return docList;
	}

}
