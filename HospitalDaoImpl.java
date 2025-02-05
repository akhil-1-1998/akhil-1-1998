package com.java.hospital;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class HospitalDaoImpl implements HospitalDao{
	
	SessionFactory factory;
	Session session;
	@Override
	public String addHospital(Hospital hospital) {
		factory=SessionHelper.getSession();
		session=factory.openSession();
		Transaction trn=session.beginTransaction();
		session.save(hospital);
		trn.commit();
		return ("Hospital information saved");
		
	}

	@Override
	public List<Hospital> showhospital() {
		factory=SessionHelper.getSession();
		session=factory.openSession();
		Criteria cr=session.createCriteria(Hospital.class);
		return cr.list();
		// TODO Auto-generated method stub
	}

}
