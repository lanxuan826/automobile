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

import com.automobile.dao.SalevoucherHDAO;
import com.automobile.model.SalevoucherH;
import com.automobile.model.SalevoucherH;
import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;

/**
 * Home object for domain model class SalevoucherH.
 * @see com.automobile.model.SalevoucherH
 * @author Hibernate Tools
 */
public class SalevoucherHDAOImpl  extends BaseDAOImpl implements SalevoucherHDAO {
	
	
	private static final Logger log = LoggerFactory.getLogger(SalevoucherHDAOImpl.class);
	// property constants
	public static final String WORD = "word";
	public static final String SalevoucherH_VALUE = "SalevoucherHValue";

	public void save(SalevoucherH transientInstance) {
		log.debug("saving SalevoucherH instance");
		try {
			getSessionFactory().getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(SalevoucherH persistentInstance) {
		log.debug("deleting SalevoucherH instance");
		try {
			getSessionFactory().getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public SalevoucherH findById(java.lang.Integer id) {
		log.debug("getting SalevoucherH instance with id: " + id);
		try {
			SalevoucherH instance = (SalevoucherH) getSessionFactory().getCurrentSession().get("com.yuqing.model.SalevoucherH", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(SalevoucherH instance) {
		log.debug("finding SalevoucherH instance by example");
		try {
			List results = getSessionFactory().getCurrentSession().createCriteria("com.yuqing.model.SalevoucherH")
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
		log.debug("finding SalevoucherH instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from SalevoucherH as model where model."
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

	public List findBySalevoucherHValue(Object SalevoucherHValue) {
		return findByProperty(SalevoucherH_VALUE, SalevoucherHValue);
	}

	public List findAll() {
		log.debug("finding all SalevoucherH instances");
		try {
			String queryString = "from SalevoucherH";
			Query queryObject = getSessionFactory().getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public SalevoucherH merge(SalevoucherH detachedInstance) {
		log.debug("merging SalevoucherH instance");
		try {
			SalevoucherH result = (SalevoucherH) getSessionFactory().getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(SalevoucherH instance) {
		log.debug("attaching dirty SalevoucherH instance");
		try {
			getSessionFactory().getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(SalevoucherH instance) {
		log.debug("attaching clean SalevoucherH instance");
		try {
			getSessionFactory().getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

}
