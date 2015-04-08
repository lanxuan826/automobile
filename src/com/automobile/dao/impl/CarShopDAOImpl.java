package com.automobile.dao.impl;

import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

import com.automobile.dao.CarShopDAO;
import com.automobile.model.CarShop;
import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;

public class CarShopDAOImpl extends BaseDAOImpl implements CarShopDAO {
	
	
	private static final Logger log = LoggerFactory.getLogger(CarShopDAOImpl.class);
	// property constants
	public static final String WORD = "word";
	public static final String CarShop_VALUE = "CarShopValue";

	public void save(CarShop transientInstance) {
		log.debug("saving CarShop instance");
		try {
			getSessionFactory().getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(CarShop persistentInstance) {
		log.debug("deleting CarShop instance");
		try {
			getSessionFactory().getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public CarShop findById(java.lang.Integer id) {
		log.debug("getting CarShop instance with id: " + id);
		try {
			CarShop instance = (CarShop) getSessionFactory().getCurrentSession().get("com.yuqing.model.CarShop", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(CarShop instance) {
		log.debug("finding CarShop instance by example");
		try {
			List results = getSessionFactory().getCurrentSession().createCriteria("com.yuqing.model.CarShop")
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
		log.debug("finding CarShop instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from CarShop as model where model."
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

	public List findByCarShopValue(Object CarShopValue) {
		return findByProperty(CarShop_VALUE, CarShopValue);
	}

	public List findAll() {
		log.debug("finding all CarShop instances");
		try {
			String queryString = "from CarShop";
			Query queryObject = getSessionFactory().getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public CarShop merge(CarShop detachedInstance) {
		log.debug("merging CarShop instance");
		try {
			CarShop result = (CarShop) getSessionFactory().getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(CarShop instance) {
		log.debug("attaching dirty CarShop instance");
		try {
			getSessionFactory().getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(CarShop instance) {
		log.debug("attaching clean CarShop instance");
		try {
			getSessionFactory().getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}