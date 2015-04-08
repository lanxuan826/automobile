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

import com.automobile.dao.SalevoucherBDAO;
import com.automobile.model.SalevoucherB;
import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;

/**
 * Home object for domain model class SalevoucherB.
 * @see com.automobile.model.SalevoucherB
 * @author Hibernate Tools
 */
public class SalevoucherBDAOImpl  extends BaseDAOImpl implements SalevoucherBDAO {
	
	
	private static final Logger log = LoggerFactory.getLogger(SalevoucherBDAOImpl.class);
	// property constants
	public static final String WORD = "word";
	public static final String SalevoucherB_VALUE = "SalevoucherBValue";

	public void save(SalevoucherB transientInstance) {
		log.debug("saving SalevoucherB instance");
		try {
			getSessionFactory().getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(SalevoucherB persistentInstance) {
		log.debug("deleting SalevoucherB instance");
		try {
			getSessionFactory().getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public SalevoucherB findById(java.lang.Integer id) {
		log.debug("getting SalevoucherB instance with id: " + id);
		try {
			SalevoucherB instance = (SalevoucherB) getSessionFactory().getCurrentSession().get("com.yuqing.model.SalevoucherB", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(SalevoucherB instance) {
		log.debug("finding SalevoucherB instance by example");
		try {
			List results = getSessionFactory().getCurrentSession().createCriteria("com.yuqing.model.SalevoucherB")
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
		log.debug("finding SalevoucherB instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from SalevoucherB as model where model."
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

	public List findBySalevoucherBValue(Object SalevoucherBValue) {
		return findByProperty(SalevoucherB_VALUE, SalevoucherBValue);
	}

	public List findAll() {
		log.debug("finding all SalevoucherB instances");
		try {
			String queryString = "from SalevoucherB";
			Query queryObject = getSessionFactory().getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public SalevoucherB merge(SalevoucherB detachedInstance) {
		log.debug("merging SalevoucherB instance");
		try {
			SalevoucherB result = (SalevoucherB) getSessionFactory().getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(SalevoucherB instance) {
		log.debug("attaching dirty SalevoucherB instance");
		try {
			getSessionFactory().getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(SalevoucherB instance) {
		log.debug("attaching clean SalevoucherB instance");
		try {
			getSessionFactory().getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

}
