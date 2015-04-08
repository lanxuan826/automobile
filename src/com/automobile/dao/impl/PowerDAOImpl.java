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

import com.automobile.dao.PowerDAO;
import com.automobile.model.Power;
import com.automobile.model.Power;
import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;

/**
 * Home object for domain model class TPower.
 * @see com.automobile.model.Power
 * @author Hibernate Tools
 */
public class PowerDAOImpl  extends BaseDAOImpl implements PowerDAO {
	
	
	private static final Logger log = LoggerFactory.getLogger(PowerDAOImpl.class);
	// property constants
	public static final String WORD = "word";
	public static final String Power_VALUE = "PowerValue";

	public void save(Power transientInstance) {
		log.debug("saving Power instance");
		try {
			getSessionFactory().getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Power persistentInstance) {
		log.debug("deleting Power instance");
		try {
			getSessionFactory().getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Power findById(java.lang.Integer id) {
		log.debug("getting Power instance with id: " + id);
		try {
			Power instance = (Power) getSessionFactory().getCurrentSession().get("com.yuqing.model.Power", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Power instance) {
		log.debug("finding Power instance by example");
		try {
			List results = getSessionFactory().getCurrentSession().createCriteria("com.yuqing.model.Power")
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
		log.debug("finding Power instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Power as model where model."
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

	public List findByPowerValue(Object PowerValue) {
		return findByProperty(Power_VALUE, PowerValue);
	}

	public List findAll() {
		log.debug("finding all Power instances");
		try {
			String queryString = "from Power";
			Query queryObject = getSessionFactory().getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Power merge(Power detachedInstance) {
		log.debug("merging Power instance");
		try {
			Power result = (Power) getSessionFactory().getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Power instance) {
		log.debug("attaching dirty Power instance");
		try {
			getSessionFactory().getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Power instance) {
		log.debug("attaching clean Power instance");
		try {
			getSessionFactory().getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

}
