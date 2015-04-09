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

import com.automobile.dao.StoInventoryDAO;
import com.automobile.model.StoInventory;
import com.automobile.model.StoInventory;
import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;

/**
 * Home object for domain model class StoInventory.
 * @see com.automobile.model.StoInventory
 * @author Hibernate Tools
 */
public class StoInventoryDAOImpl  extends BaseDAOImpl implements StoInventoryDAO {
	
	
	private static final Logger log = LoggerFactory.getLogger(StoInventoryDAOImpl.class);
	// property constants
	public static final String WORD = "word";
	public static final String StoInventory_VALUE = "StoInventoryValue";

	public void save(StoInventory transientInstance) {
		log.debug("saving StoInventory instance");
		try {
			getSessionFactory().getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(StoInventory persistentInstance) {
		log.debug("deleting StoInventory instance");
		try {
			getSessionFactory().getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public StoInventory findById(java.lang.Integer id) {
		log.debug("getting StoInventory instance with id: " + id);
		try {
			StoInventory instance = (StoInventory) getSessionFactory().getCurrentSession().get("com.yuqing.model.StoInventory", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(StoInventory instance) {
		log.debug("finding StoInventory instance by example");
		try {
			List results = getSessionFactory().getCurrentSession().createCriteria("com.yuqing.model.StoInventory")
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
		log.debug("finding StoInventory instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from StoInventory as model where model."
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

	public List findByStoInventoryValue(Object StoInventoryValue) {
		return findByProperty(StoInventory_VALUE, StoInventoryValue);
	}

	public List findAll() {
		log.debug("finding all StoInventory instances");
		try {
			String queryString = "from StoInventory";
			Query queryObject = getSessionFactory().getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public StoInventory merge(StoInventory detachedInstance) {
		log.debug("merging StoInventory instance");
		try {
			StoInventory result = (StoInventory) getSessionFactory().getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(StoInventory instance) {
		log.debug("attaching dirty StoInventory instance");
		try {
			getSessionFactory().getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(StoInventory instance) {
		log.debug("attaching clean StoInventory instance");
		try {
			getSessionFactory().getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}