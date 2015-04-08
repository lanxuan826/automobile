package com.automobile.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.automobile.dao.UserDAO;
import com.automobile.model.User;

public class UserDAOImpl extends BaseDAOImpl implements UserDAO {
	
	private static final Logger log = LoggerFactory.getLogger(UserDAOImpl.class);

	/**
	 * ����User
	 */
	public void save(User user) {
		try {
			getSessionFactory().getCurrentSession().save(user);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * ͨ��name����User
	 * @return User
	 */
	public List findUserByName(String username) {
		return findUserByProperty("username", username);
	}

	/**
	 * ͨ��ID����User
	 * @return User
	 */
	public User findUserById(Integer Id) {
		try {
			User instance = (User) getSessionFactory().getCurrentSession().get("com.automobile.model.User", Id);
			return instance;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * ͨ��propertyName����User
	 * @param String propertyName 
	 * @param Object value
	 * @return List
	 */
	public List findUserByProperty(String propertyName, Object value) {
		
		try{
			String querySql = "from User as model where model."+propertyName+"=?";
			Query query = getSessionFactory().getCurrentSession().createQuery(querySql);
			query.setParameter(0, value);
			return query.list();
		}catch(Exception ex) {
			throw ex;
		}
	}

	/**
	 * �ж��û����Ƿ����
	 */
	public boolean isExits(String username) {
			Session session = getSessionFactory().getCurrentSession();
			String sql = "select user_id from User as u where u.username=?";
			Query query = session.createQuery(sql);
			query.setParameter(0,username);
			return query.uniqueResult() == null ? false:true;
	}

	@Override
	public List<User> showUserListAll() {
		try {
			String queryString = "from User";
			Query queryObject = getSessionFactory().getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	@Override
	public void delele(User user) {
		try {
			getSessionFactory().getCurrentSession().delete(user);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
	}

	@Override
	public void update(User user) {
		try {
			getSessionFactory().getCurrentSession().update(user);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
	}
		
}
