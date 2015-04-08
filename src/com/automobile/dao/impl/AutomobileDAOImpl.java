package com.automobile.dao.impl;

import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

import com.automobile.dao.AutomobileDAO;
import com.automobile.model.Automobile;
import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;

public class AutomobileDAOImpl extends BaseDAOImpl implements AutomobileDAO {
	
	
	private static final Logger log = LoggerFactory.getLogger(AutomobileDAOImpl.class);
	// property constants
	public static final String WORD = "word";
	public static final String Automobile_VALUE = "AutomobileValue";

	public void save(Automobile transientInstance) {
		log.debug("saving Automobile instance");
		try {
			getSessionFactory().getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Automobile persistentInstance) {
		log.debug("deleting Automobile instance");
		try {
			getSessionFactory().getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Automobile findById(java.lang.Integer id) {
		log.debug("getting Automobile instance with id: " + id);
		try {
			Automobile instance = (Automobile) getSessionFactory().getCurrentSession().get("com.yuqing.model.Automobile", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Automobile instance) {
		log.debug("finding Automobile instance by example");
		try {
			List results = getSessionFactory().getCurrentSession().createCriteria("com.yuqing.model.Automobile")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Automobile instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Automobile as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSessionFactory().getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByWord(Object word) {
		return findByProperty(WORD, word);
	}

	public List findByAutomobileValue(Object AutomobileValue) {
		return findByProperty(Automobile_VALUE, AutomobileValue);
	}

	public List findAll() {
		log.debug("finding all Automobile instances");
		try {
			String queryString = "from Automobile";
			Query queryObject = getSessionFactory().getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Automobile merge(Automobile detachedInstance) {
		log.debug("merging Automobile instance");
		try {
			Automobile result = (Automobile) getSessionFactory().getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Automobile instance) {
		log.debug("attaching dirty Automobile instance");
		try {
			getSessionFactory().getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Automobile instance) {
		log.debug("attaching clean Automobile instance");
		try {
			getSessionFactory().getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}
	
