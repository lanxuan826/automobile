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

import com.automobile.dao.SaleVoucherBDAO;
import com.automobile.model.SaleVoucherB;
import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;

/**
 * Home object for domain model class SaleVoucherB.
 * @see com.automobile.model.SaleVoucherB
 * @author Hibernate Tools
 */
public class SaleVoucherBDAOImpl  extends BaseDAOImpl implements SaleVoucherBDAO {
	
	
	private static final Logger log = LoggerFactory.getLogger(SaleVoucherBDAOImpl.class);
	// property constants
	public static final String WORD = "word";
	public static final String SaleVoucherB_VALUE = "SaleVoucherBValue";

	public void save(SaleVoucherB transientInstance) {
		log.debug("saving SaleVoucherB instance");
		try {
			getSessionFactory().getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(SaleVoucherB persistentInstance) {
		log.debug("deleting SaleVoucherB instance");
		try {
			getSessionFactory().getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public SaleVoucherB findById(java.lang.Integer id) {
		log.debug("getting SaleVoucherB instance with id: " + id);
		try {
			SaleVoucherB instance = (SaleVoucherB) getSessionFactory().getCurrentSession().get("com.yuqing.model.SaleVoucherB", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(SaleVoucherB instance) {
		log.debug("finding SaleVoucherB instance by example");
		try {
			List results = getSessionFactory().getCurrentSession().createCriteria("com.yuqing.model.SaleVoucherB")
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
		log.debug("finding SaleVoucherB instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from SaleVoucherB as model where model."
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

	public List findBySaleVoucherBValue(Object SaleVoucherBValue) {
		return findByProperty(SaleVoucherB_VALUE, SaleVoucherBValue);
	}

	public List findAll() {
		log.debug("finding all SaleVoucherB instances");
		try {
			String queryString = "from SaleVoucherB";
			Query queryObject = getSessionFactory().getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public SaleVoucherB merge(SaleVoucherB detachedInstance) {
		log.debug("merging SaleVoucherB instance");
		try {
			SaleVoucherB result = (SaleVoucherB) getSessionFactory().getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(SaleVoucherB instance) {
		log.debug("attaching dirty SaleVoucherB instance");
		try {
			getSessionFactory().getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(SaleVoucherB instance) {
		log.debug("attaching clean SaleVoucherB instance");
		try {
			getSessionFactory().getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

}
