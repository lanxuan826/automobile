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

import com.automobile.dao.StorgeDAO;
import com.automobile.model.Storge;
import com.automobile.model.Storge;
import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;

/**
 * Home object for domain model class Storge.
 * @see com.automobile.model.Storge
 * @author Hibernate Tools
 */
public class StorgeDAOImpl extends BaseDAOImpl implements StorgeDAO {
	
	
	private static final Logger log = LoggerFactory.getLogger(StorgeDAOImpl.class);
	// property constants
	public static final String WORD = "word";
	public static final String Storge_VALUE = "StorgeValue";

	public void save(Storge transientInstance) {
		log.debug("saving Storge instance");
		try {
			getSessionFactory().getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Storge persistentInstance) {
		log.debug("deleting Storge instance");
		try {
			getSessionFactory().getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Storge findById(java.lang.Integer id) {
		log.debug("getting Storge instance with id: " + id);
		try {
			Storge instance = (Storge) getSessionFactory().getCurrentSession().get("com.yuqing.model.Storge", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Storge instance) {
		log.debug("finding Storge instance by example");
		try {
			List results = getSessionFactory().getCurrentSession().createCriteria("com.yuqing.model.Storge")
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
		log.debug("finding Storge instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Storge as model where model."
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

	public List findByStorgeValue(Object StorgeValue) {
		return findByProperty(Storge_VALUE, StorgeValue);
	}

	public List findAll() {
		log.debug("finding all Storge instances");
		try {
			String queryString = "from Storge";
			Query queryObject = getSessionFactory().getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Storge merge(Storge detachedInstance) {
		log.debug("merging Storge instance");
		try {
			Storge result = (Storge) getSessionFactory().getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Storge instance) {
		log.debug("attaching dirty Storge instance");
		try {
			getSessionFactory().getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Storge instance) {
		log.debug("attaching clean Storge instance");
		try {
			getSessionFactory().getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

}
