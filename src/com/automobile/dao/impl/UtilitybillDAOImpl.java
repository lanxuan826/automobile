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

import com.automobile.dao.UtilitybillDAO;
import com.automobile.model.Utilitybill;
import com.automobile.model.UtilitybillId;
import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;

/**
 * Home object for domain model class Utilitybill.
 * @see com.automobile.model.Utilitybill
 * @author Hibernate Tools
 */
public class UtilitybillDAOImpl extends BaseDAOImpl implements UtilitybillDAO {
	
	
	private static final Logger log = LoggerFactory.getLogger(UtilitybillDAOImpl.class);
	// property constants
	public static final String WORD = "word";
	public static final String Utilitybill_VALUE = "UtilitybillValue";

	public void save(Utilitybill transientInstance) {
		log.debug("saving Utilitybill instance");
		try {
			getSessionFactory().getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Utilitybill persistentInstance) {
		log.debug("deleting Utilitybill instance");
		try {
			getSessionFactory().getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Utilitybill findById(java.lang.Integer id) {
		log.debug("getting Utilitybill instance with id: " + id);
		try {
			Utilitybill instance = (Utilitybill) getSessionFactory().getCurrentSession().get("com.yuqing.model.Utilitybill", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Utilitybill instance) {
		log.debug("finding Utilitybill instance by example");
		try {
			List results = getSessionFactory().getCurrentSession().createCriteria("com.yuqing.model.Utilitybill")
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
		log.debug("finding Utilitybill instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Utilitybill as model where model."
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

	public List findByUtilitybillValue(Object UtilitybillValue) {
		return findByProperty(Utilitybill_VALUE, UtilitybillValue);
	}

	public List findAll() {
		log.debug("finding all Utilitybill instances");
		try {
			String queryString = "from Utilitybill";
			Query queryObject = getSessionFactory().getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Utilitybill merge(Utilitybill detachedInstance) {
		log.debug("merging Utilitybill instance");
		try {
			Utilitybill result = (Utilitybill) getSessionFactory().getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Utilitybill instance) {
		log.debug("attaching dirty Utilitybill instance");
		try {
			getSessionFactory().getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Utilitybill instance) {
		log.debug("attaching clean Utilitybill instance");
		try {
			getSessionFactory().getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

}
