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

import com.automobile.dao.OutInstorageBDAO;
import com.automobile.model.OutInStorageB;
import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;

/**
 * Home object for domain model class TOutInstorageB.
 * @see com.automobile.model.OutInstorageB
 * @author Hibernate Tools
 */
public class OutInstorageBDAOImpl  extends BaseDAOImpl implements OutInstorageBDAO {
	
	
	private static final Logger log = LoggerFactory.getLogger(OutInstorageBDAOImpl.class);
	// property constants
	public static final String WORD = "word";
	public static final String OutInstorageB_VALUE = "OutInstorageBValue";

	public void save(OutInStorageB transientInstance) {
		log.debug("saving OutInstorageB instance");
		try {
			getSessionFactory().getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(OutInStorageB persistentInstance) {
		log.debug("deleting OutInstorageB instance");
		try {
			getSessionFactory().getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public OutInStorageB findById(java.lang.Integer id) {
		log.debug("getting OutInstorageB instance with id: " + id);
		try {
			OutInStorageB instance = (OutInStorageB) getSessionFactory().getCurrentSession().get("com.yuqing.model.OutInstorageB", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(OutInStorageB instance) {
		log.debug("finding OutInstorageB instance by example");
		try {
			List results = getSessionFactory().getCurrentSession().createCriteria("com.yuqing.model.OutInstorageB")
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
		log.debug("finding OutInstorageB instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from OutInstorageB as model where model."
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

	public List findByOutInstorageBValue(Object OutInstorageBValue) {
		return findByProperty(OutInstorageB_VALUE, OutInstorageBValue);
	}

	public List findAll() {
		log.debug("finding all OutInstorageB instances");
		try {
			String queryString = "from OutInstorageB";
			Query queryObject = getSessionFactory().getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public OutInStorageB merge(OutInStorageB detachedInstance) {
		log.debug("merging OutInstorageB instance");
		try {
			OutInStorageB result = (OutInStorageB) getSessionFactory().getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(OutInStorageB instance) {
		log.debug("attaching dirty OutInstorageB instance");
		try {
			getSessionFactory().getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(OutInStorageB instance) {
		log.debug("attaching clean OutInstorageB instance");
		try {
			getSessionFactory().getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

}
