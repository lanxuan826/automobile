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

import com.automobile.dao.StoinventoryDAO;
import com.automobile.model.Stoinventory;
import com.automobile.model.Stoinventory;
import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;

/**
 * Home object for domain model class Stoinventory.
 * @see com.automobile.model.Stoinventory
 * @author Hibernate Tools
 */
public class StoinventoryDAOImpl  extends BaseDAOImpl implements StoinventoryDAO {
	
	
	private static final Logger log = LoggerFactory.getLogger(StoinventoryDAOImpl.class);
	// property constants
	public static final String WORD = "word";
	public static final String Stoinventory_VALUE = "StoinventoryValue";

	public void save(Stoinventory transientInstance) {
		log.debug("saving Stoinventory instance");
		try {
			getSessionFactory().getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Stoinventory persistentInstance) {
		log.debug("deleting Stoinventory instance");
		try {
			getSessionFactory().getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Stoinventory findById(java.lang.Integer id) {
		log.debug("getting Stoinventory instance with id: " + id);
		try {
			Stoinventory instance = (Stoinventory) getSessionFactory().getCurrentSession().get("com.yuqing.model.Stoinventory", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Stoinventory instance) {
		log.debug("finding Stoinventory instance by example");
		try {
			List results = getSessionFactory().getCurrentSession().createCriteria("com.yuqing.model.Stoinventory")
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
		log.debug("finding Stoinventory instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Stoinventory as model where model."
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

	public List findByStoinventoryValue(Object StoinventoryValue) {
		return findByProperty(Stoinventory_VALUE, StoinventoryValue);
	}

	public List findAll() {
		log.debug("finding all Stoinventory instances");
		try {
			String queryString = "from Stoinventory";
			Query queryObject = getSessionFactory().getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Stoinventory merge(Stoinventory detachedInstance) {
		log.debug("merging Stoinventory instance");
		try {
			Stoinventory result = (Stoinventory) getSessionFactory().getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Stoinventory instance) {
		log.debug("attaching dirty Stoinventory instance");
		try {
			getSessionFactory().getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Stoinventory instance) {
		log.debug("attaching clean Stoinventory instance");
		try {
			getSessionFactory().getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}