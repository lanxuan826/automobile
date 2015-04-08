package com.automobile.dao.impl;

import org.hibernate.SessionFactory;

import com.automobile.dao.BaseDAO;

public class BaseDAOImpl implements BaseDAO {
			
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


}
