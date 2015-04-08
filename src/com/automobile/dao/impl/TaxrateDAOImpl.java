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

import com.automobile.dao.TaxrateDAO;
import com.automobile.model.Taxrate;
import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;

/**
 * Home object for domain model class Taxrate.
 * @see com.automobile.model.Taxrate
 * @author Hibernate Tools
 */
public class TaxrateDAOImpl extends BaseDAOImpl implements TaxrateDAO {
	
	
	private static final Logger log = LoggerFactory.getLogger(TaxrateDAOImpl.class);
	// property constants
	public static final String WORD = "word";
	public static final String Taxrate_VALUE = "TaxrateValue";

	public void save(Taxrate transientInstance) {
		log.debug("saving Taxrate instance");
		try {
			getSessionFactory().getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Taxrate persistentInstance) {
		log.debug("deleting Taxrate instance");
		try {
			getSessionFactory().getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Taxrate findById(java.lang.Integer id) {
		log.debug("getting Taxrate instance with id: " + id);
		try {
			Taxrate instance = (Taxrate) getSessionFactory().getCurrentSession().get("com.yuqing.model.Taxrate", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Taxrate instance) {
		log.debug("finding Taxrate instance by example");
		try {
			List results = getSessionFactory().getCurrentSession().createCriteria("com.yuqing.model.Taxrate")
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
		log.debug("finding Taxrate instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Taxrate as model where model."
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

	public List findByTaxrateValue(Object TaxrateValue) {
		return findByProperty(Taxrate_VALUE, TaxrateValue);
	}

	public List findAll() {
		log.debug("finding all Taxrate instances");
		try {
			String queryString = "from Taxrate";
			Query queryObject = getSessionFactory().getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Taxrate merge(Taxrate detachedInstance) {
		log.debug("merging Taxrate instance");
		try {
			Taxrate result = (Taxrate) getSessionFactory().getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Taxrate instance) {
		log.debug("attaching dirty Taxrate instance");
		try {
			getSessionFactory().getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Taxrate instance) {
		log.debug("attaching clean Taxrate instance");
		try {
			getSessionFactory().getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

}
