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

import com.automobile.dao.OutinstorageBDAO;
import com.automobile.model.OutinstorageB;
import com.automobile.model.OutinstorageB;
import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;

/**
 * Home object for domain model class TOutinstorageB.
 * @see com.automobile.model.OutinstorageB
 * @author Hibernate Tools
 */
public class OutinstorageBDAOImpl  extends BaseDAOImpl implements OutinstorageBDAO {
	
	
	private static final Logger log = LoggerFactory.getLogger(OutinstorageBDAOImpl.class);
	// property constants
	public static final String WORD = "word";
	public static final String OutinstorageB_VALUE = "OutinstorageBValue";

	public void save(OutinstorageB transientInstance) {
		log.debug("saving OutinstorageB instance");
		try {
			getSessionFactory().getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(OutinstorageB persistentInstance) {
		log.debug("deleting OutinstorageB instance");
		try {
			getSessionFactory().getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public OutinstorageB findById(java.lang.Integer id) {
		log.debug("getting OutinstorageB instance with id: " + id);
		try {
			OutinstorageB instance = (OutinstorageB) getSessionFactory().getCurrentSession().get("com.yuqing.model.OutinstorageB", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(OutinstorageB instance) {
		log.debug("finding OutinstorageB instance by example");
		try {
			List results = getSessionFactory().getCurrentSession().createCriteria("com.yuqing.model.OutinstorageB")
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
		log.debug("finding OutinstorageB instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from OutinstorageB as model where model."
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

	public List findByOutinstorageBValue(Object OutinstorageBValue) {
		return findByProperty(OutinstorageB_VALUE, OutinstorageBValue);
	}

	public List findAll() {
		log.debug("finding all OutinstorageB instances");
		try {
			String queryString = "from OutinstorageB";
			Query queryObject = getSessionFactory().getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public OutinstorageB merge(OutinstorageB detachedInstance) {
		log.debug("merging OutinstorageB instance");
		try {
			OutinstorageB result = (OutinstorageB) getSessionFactory().getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(OutinstorageB instance) {
		log.debug("attaching dirty OutinstorageB instance");
		try {
			getSessionFactory().getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(OutinstorageB instance) {
		log.debug("attaching clean OutinstorageB instance");
		try {
			getSessionFactory().getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

}
