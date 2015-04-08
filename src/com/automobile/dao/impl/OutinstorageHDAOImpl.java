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

import com.automobile.dao.OutinstorageHDAO;
import com.automobile.model.OutinstorageH;
import com.automobile.model.OutinstorageH;
import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;

/**
 * Home object for domain model class TOutinstorageH.
 * @see com.automobile.model.OutinstorageH
 * @author Hibernate Tools
 */
public class OutinstorageHDAOImpl  extends BaseDAOImpl implements OutinstorageHDAO {
	
	
	private static final Logger log = LoggerFactory.getLogger(OutinstorageHDAOImpl.class);
	// property constants
	public static final String WORD = "word";
	public static final String OutinstorageH_VALUE = "OutinstorageHValue";

	public void save(OutinstorageH transientInstance) {
		log.debug("saving OutinstorageH instance");
		try {
			getSessionFactory().getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(OutinstorageH persistentInstance) {
		log.debug("deleting OutinstorageH instance");
		try {
			getSessionFactory().getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public OutinstorageH findById(java.lang.Integer id) {
		log.debug("getting OutinstorageH instance with id: " + id);
		try {
			OutinstorageH instance = (OutinstorageH) getSessionFactory().getCurrentSession().get("com.yuqing.model.OutinstorageH", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(OutinstorageH instance) {
		log.debug("finding OutinstorageH instance by example");
		try {
			List results = getSessionFactory().getCurrentSession().createCriteria("com.yuqing.model.OutinstorageH")
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
		log.debug("finding OutinstorageH instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from OutinstorageH as model where model."
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

	public List findByOutinstorageHValue(Object OutinstorageHValue) {
		return findByProperty(OutinstorageH_VALUE, OutinstorageHValue);
	}

	public List findAll() {
		log.debug("finding all OutinstorageH instances");
		try {
			String queryString = "from OutinstorageH";
			Query queryObject = getSessionFactory().getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public OutinstorageH merge(OutinstorageH detachedInstance) {
		log.debug("merging OutinstorageH instance");
		try {
			OutinstorageH result = (OutinstorageH) getSessionFactory().getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(OutinstorageH instance) {
		log.debug("attaching dirty OutinstorageH instance");
		try {
			getSessionFactory().getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(OutinstorageH instance) {
		log.debug("attaching clean OutinstorageH instance");
		try {
			getSessionFactory().getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}