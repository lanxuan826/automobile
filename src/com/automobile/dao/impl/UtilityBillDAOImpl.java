package com.automobile.dao.impl;

// Generated 2015-4-7 21:58:34 by Hibernate Tools 3.2.2.GA

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

import com.automobile.dao.UtilityBillDAO;
import com.automobile.dao.UtilityBillDAO;
import com.automobile.model.UtilityBill;
import com.automobile.model.UtilityBillId;
import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;

/**
 * Home object for domain model class UtilityBill.
 * @see com.automobile.model.UtilityBill
 * @author Hibernate Tools
 */
public class UtilityBillDAOImpl extends BaseDAOImpl implements UtilityBillDAO {
	
	
	private static final Logger log = LoggerFactory.getLogger(UtilityBillDAOImpl.class);
	// property constants
	public static final String WORD = "word";
	public static final String UtilityBill_VALUE = "UtilityBillValue";

	public void save(UtilityBill transientInstance) {
		log.debug("saving UtilityBill instance");
		try {
			getSessionFactory().getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(UtilityBill persistentInstance) {
		log.debug("deleting UtilityBill instance");
		try {
			getSessionFactory().getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public UtilityBill findById(java.lang.Integer id) {
		log.debug("getting UtilityBill instance with id: " + id);
		try {
			UtilityBill instance = (UtilityBill) getSessionFactory().getCurrentSession().get("com.yuqing.model.UtilityBill", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(UtilityBill instance) {
		log.debug("finding UtilityBill instance by example");
		try {
			List results = getSessionFactory().getCurrentSession().createCriteria("com.yuqing.model.UtilityBill")
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
		log.debug("finding UtilityBill instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from UtilityBill as model where model."
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

	public List findByUtilityBillValue(Object UtilityBillValue) {
		return findByProperty(UtilityBill_VALUE, UtilityBillValue);
	}

	public List findAll() {
		log.debug("finding all UtilityBill instances");
		try {
			String queryString = "from UtilityBill";
			Query queryObject = getSessionFactory().getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public UtilityBill merge(UtilityBill detachedInstance) {
		log.debug("merging UtilityBill instance");
		try {
			UtilityBill result = (UtilityBill) getSessionFactory().getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(UtilityBill instance) {
		log.debug("attaching dirty UtilityBill instance");
		try {
			getSessionFactory().getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(UtilityBill instance) {
		log.debug("attaching clean UtilityBill instance");
		try {
			getSessionFactory().getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

}
