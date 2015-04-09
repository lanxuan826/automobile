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

import com.automobile.dao.SaleVoucherHDAO;
import com.automobile.model.SaleVoucherH;
import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;

/**
 * Home object for domain model class SaleVoucherH.
 * @see com.automobile.model.SaleVoucherH
 * @author Hibernate Tools
 */
public class SaleVoucherHDAOImpl  extends BaseDAOImpl implements SaleVoucherHDAO {
	
	
	private static final Logger log = LoggerFactory.getLogger(SaleVoucherHDAOImpl.class);
	// property constants
	public static final String WORD = "word";
	public static final String SaleVoucherH_VALUE = "SaleVoucherHValue";

	public void save(SaleVoucherH transientInstance) {
		log.debug("saving SaleVoucherH instance");
		try {
			getSessionFactory().getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(SaleVoucherH persistentInstance) {
		log.debug("deleting SaleVoucherH instance");
		try {
			getSessionFactory().getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public SaleVoucherH findById(java.lang.Integer id) {
		log.debug("getting SaleVoucherH instance with id: " + id);
		try {
			SaleVoucherH instance = (SaleVoucherH) getSessionFactory().getCurrentSession().get("com.yuqing.model.SaleVoucherH", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(SaleVoucherH instance) {
		log.debug("finding SaleVoucherH instance by example");
		try {
			List results = getSessionFactory().getCurrentSession().createCriteria("com.yuqing.model.SaleVoucherH")
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
		log.debug("finding SaleVoucherH instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from SaleVoucherH as model where model."
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

	public List findBySaleVoucherHValue(Object SaleVoucherHValue) {
		return findByProperty(SaleVoucherH_VALUE, SaleVoucherHValue);
	}

	public List findAll() {
		log.debug("finding all SaleVoucherH instances");
		try {
			String queryString = "from SaleVoucherH";
			Query queryObject = getSessionFactory().getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public SaleVoucherH merge(SaleVoucherH detachedInstance) {
		log.debug("merging SaleVoucherH instance");
		try {
			SaleVoucherH result = (SaleVoucherH) getSessionFactory().getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(SaleVoucherH instance) {
		log.debug("attaching dirty SaleVoucherH instance");
		try {
			getSessionFactory().getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(SaleVoucherH instance) {
		log.debug("attaching clean SaleVoucherH instance");
		try {
			getSessionFactory().getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	@Override
	public List findBySalevoucherHValue(Object SalevoucherHValue) {
		// TODO Auto-generated method stub
		return null;
	}

}
