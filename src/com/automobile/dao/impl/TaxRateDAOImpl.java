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

import com.automobile.dao.TaxRateDAO;
import com.automobile.model.TaxRate;
import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;

/**
 * Home object for domain model class TaxRate.
 * @see com.automobile.model.TaxRate
 * @author Hibernate Tools
 */
public class TaxRateDAOImpl extends BaseDAOImpl implements TaxRateDAO {
	
	
	private static final Logger log = LoggerFactory.getLogger(TaxRateDAOImpl.class);
	// property constants
	public static final String WORD = "word";
	public static final String TaxRate_VALUE = "TaxRateValue";

	public void save(TaxRate transientInstance) {
		log.debug("saving TaxRate instance");
		try {
			getSessionFactory().getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TaxRate persistentInstance) {
		log.debug("deleting TaxRate instance");
		try {
			getSessionFactory().getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TaxRate findById(java.lang.Integer id) {
		log.debug("getting TaxRate instance with id: " + id);
		try {
			TaxRate instance = (TaxRate) getSessionFactory().getCurrentSession().get("com.automobile.model.TaxRate", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TaxRate instance) {
		log.debug("finding TaxRate instance by example");
		try {
			List results = getSessionFactory().getCurrentSession().createCriteria("com.automobile.model.TaxRate")
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
		log.debug("finding TaxRate instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from TaxRate as model where model."
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

	public List findByTaxRateValue(Object TaxRateValue) {
		return findByProperty(TaxRate_VALUE, TaxRateValue);
	}

	public List findAll() {
		log.debug("finding all TaxRate instances");
		try {
			String queryString = "from TaxRate";
			Query queryObject = getSessionFactory().getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TaxRate merge(TaxRate detachedInstance) {
		log.debug("merging TaxRate instance");
		try {
			TaxRate result = (TaxRate) getSessionFactory().getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TaxRate instance) {
		log.debug("attaching dirty TaxRate instance");
		try {
			getSessionFactory().getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TaxRate instance) {
		log.debug("attaching clean TaxRate instance");
		try {
			getSessionFactory().getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

}
