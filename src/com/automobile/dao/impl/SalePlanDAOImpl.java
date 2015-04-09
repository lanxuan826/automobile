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

import com.automobile.dao.SalePlanDAO;
import com.automobile.model.SalePlan;
import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;

/**
 * Home object for domain model class TSalePlan.
 * @see com.automobile.model.SalePlan
 * @author Hibernate Tools
 */
public class SalePlanDAOImpl  extends BaseDAOImpl implements SalePlanDAO {
	
	
	private static final Logger log = LoggerFactory.getLogger(SalePlanDAOImpl.class);
	// property constants
	public static final String WORD = "word";
	public final String SalePlan_VALUE = "SalePlanValue";

	public void save(SalePlan transientInstance) {
		log.debug("savingSalePlan instance");
		try {
			getSessionFactory().getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(SalePlan persistentInstance) {
		log.debug("deletingSalePlan instance");
		try {
			getSessionFactory().getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public SalePlan findById(java.lang.Integer id) {
		log.debug("gettingSalePlan instance with id: " + id);
		try {
			SalePlan instance = (SalePlan) getSessionFactory().getCurrentSession().get("com.yuqing.model.SalePlan", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(SalePlan instance) {
		log.debug("findingSalePlan instance by example");
		try {
			List results = getSessionFactory().getCurrentSession().createCriteria("com.yuqing.model.SalePlan")
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
		log.debug("findingSalePlan instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "fromSalePlan as model where model."
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

	public List findBySalePlanValue(Object SalePlanValue) {
		return findByProperty(SalePlan_VALUE,SalePlanValue);
	}

	public List findAll() {
		log.debug("finding allSalePlan instances");
		try {
			String queryString = "fromSalePlan";
			Query queryObject = getSessionFactory().getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public SalePlan merge(SalePlan detachedInstance) {
		log.debug("mergingSalePlan instance");
		try {
			SalePlan result = (SalePlan) getSessionFactory().getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(SalePlan instance) {
		log.debug("attaching dirtySalePlan instance");
		try {
			getSessionFactory().getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(SalePlan instance) {
		log.debug("attaching cleanSalePlan instance");
		try {
			getSessionFactory().getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	@Override
	public List findBySaleplanValue(Object SaleplanValue) {
		// TODO Auto-generated method stub
		return null;
	}

}
