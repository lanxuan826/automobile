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

import com.automobile.dao.SaleplanDAO;
import com.automobile.model.Saleplan;
import com.automobile.model.Saleplan;
import com.automobile.model.SaleplanId;
import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;

/**
 * Home object for domain model class TSaleplan.
 * @see com.automobile.model.Saleplan
 * @author Hibernate Tools
 */
public class SaleplanDAOImpl  extends BaseDAOImpl implements SaleplanDAO {
	
	
	private static final Logger log = LoggerFactory.getLogger(SaleplanDAOImpl.class);
	// property constants
	public static final String WORD = "word";
	public final String Saleplan_VALUE = "SaleplanValue";

	public void save(Saleplan transientInstance) {
		log.debug("savingSaleplan instance");
		try {
			getSessionFactory().getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Saleplan persistentInstance) {
		log.debug("deletingSaleplan instance");
		try {
			getSessionFactory().getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Saleplan findById(java.lang.Integer id) {
		log.debug("gettingSaleplan instance with id: " + id);
		try {
			Saleplan instance = (Saleplan) getSessionFactory().getCurrentSession().get("com.yuqing.model.Saleplan", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Saleplan instance) {
		log.debug("findingSaleplan instance by example");
		try {
			List results = getSessionFactory().getCurrentSession().createCriteria("com.yuqing.model.Saleplan")
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
		log.debug("findingSaleplan instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "fromSaleplan as model where model."
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

	public List findBySaleplanValue(Object SaleplanValue) {
		return findByProperty(Saleplan_VALUE,SaleplanValue);
	}

	public List findAll() {
		log.debug("finding allSaleplan instances");
		try {
			String queryString = "fromSaleplan";
			Query queryObject = getSessionFactory().getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Saleplan merge(Saleplan detachedInstance) {
		log.debug("mergingSaleplan instance");
		try {
			Saleplan result = (Saleplan) getSessionFactory().getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Saleplan instance) {
		log.debug("attaching dirtySaleplan instance");
		try {
			getSessionFactory().getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Saleplan instance) {
		log.debug("attaching cleanSaleplan instance");
		try {
			getSessionFactory().getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

}
