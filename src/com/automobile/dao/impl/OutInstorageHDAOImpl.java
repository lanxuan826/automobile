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

import com.automobile.dao.OutInstorageHDAO;
import com.automobile.model.OutInStorageH;
import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;

/**
 * Home object for domain model class TOutInstorageH.
 * @see com.automobile.model.OutInstorageH
 * @author Hibernate Tools
 */
public class OutInstorageHDAOImpl  extends BaseDAOImpl implements OutInstorageHDAO {
	
	
	private static final Logger log = LoggerFactory.getLogger(OutInstorageHDAOImpl.class);
	// property constants
	public static final String WORD = "word";
	public static final String OutInstorageH_VALUE = "OutInstorageHValue";

	public void save(OutInStorageH transientInstance) {
		log.debug("saving OutInstorageH instance");
		try {
			getSessionFactory().getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(OutInStorageH persistentInstance) {
		log.debug("deleting OutInstorageH instance");
		try {
			getSessionFactory().getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public OutInStorageH findById(java.lang.Integer id) {
		log.debug("getting OutInstorageH instance with id: " + id);
		try {
			OutInStorageH instance = (OutInStorageH) getSessionFactory().getCurrentSession().get("com.yuqing.model.OutInstorageH", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(OutInStorageH instance) {
		log.debug("finding OutInstorageH instance by example");
		try {
			List results = getSessionFactory().getCurrentSession().createCriteria("com.yuqing.model.OutInstorageH")
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
		log.debug("finding OutInstorageH instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from OutInstorageH as model where model."
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

	public List findByOutInstorageHValue(Object OutInstorageHValue) {
		return findByProperty(OutInstorageH_VALUE, OutInstorageHValue);
	}

	public List findAll() {
		log.debug("finding all OutInstorageH instances");
		try {
			String queryString = "from OutInstorageH";
			Query queryObject = getSessionFactory().getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public OutInStorageH merge(OutInStorageH detachedInstance) {
		log.debug("merging OutInstorageH instance");
		try {
			OutInStorageH result = (OutInStorageH) getSessionFactory().getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(OutInStorageH instance) {
		log.debug("attaching dirty OutInstorageH instance");
		try {
			getSessionFactory().getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(OutInStorageH instance) {
		log.debug("attaching clean OutInstorageH instance");
		try {
			getSessionFactory().getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	@Override
	public List findByOutinstorageHValue(Object OutinstorageHValue) {
		// TODO Auto-generated method stub
		return null;
	}
}