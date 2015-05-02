package com.automobile.dao.impl;

// Generated 2015-4-7 21:58:34 by Hibernate Tools 3.2.2.GA

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Example;

import com.automobile.dao.DealerDAO;
import com.automobile.model.Dealer;
import com.automobile.model.Dealer;
import com.automobile.model.User;
import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;

public class DealerDAOImpl  extends BaseDAOImpl implements DealerDAO {
	
	
	private static final Logger log = LoggerFactory.getLogger(DealerDAOImpl.class);
	// property constants
	public static final String WORD = "word";
	public static final String Dealer_VALUE = "DealerValue";

	public void save(Dealer transientInstance) {
		log.debug("saving Dealer instance");
		try {
			getSessionFactory().getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Dealer persistentInstance) {
		log.debug("deleting Dealer instance");
		try {
			getSessionFactory().getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Dealer findById(java.lang.Integer id) {
		log.debug("getting Dealer instance with id: " + id);
		try {
			Dealer instance = (Dealer) getSessionFactory().getCurrentSession().get("com.yuqing.model.Dealer", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Dealer instance) {
		log.debug("finding Dealer instance by example");
		try {
			List results = getSessionFactory().getCurrentSession().createCriteria("com.yuqing.model.Dealer")
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
		log.debug("finding Dealer instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Dealer as model where model."
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

	public List findByDealerValue(Object DealerValue) {
		return findByProperty(Dealer_VALUE, DealerValue);
	}

	public List findAll() {
		log.debug("finding all Dealer instances");
		try {
			String queryString = "from Dealer";
			Query queryObject = getSessionFactory().getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
	public List<Dealer> showDealerListAll() {
		log.debug("finding all Dealer instances");
		try {
			String queryString = "from Dealer";
			Session session = getSessionFactory().getCurrentSession();
			Query queryObject = session.createQuery(queryString);
//			Query queryObject = getSessionFactory().getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
	


	public Dealer merge(Dealer detachedInstance) {
		log.debug("merging Dealer instance");
		try {
			Dealer result = (Dealer) getSessionFactory().getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Dealer instance) {
		log.debug("attaching dirty Dealer instance");
		try {
			getSessionFactory().getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Dealer instance) {
		log.debug("attaching clean Dealer instance");
		try {
			getSessionFactory().getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	@Override
	public List<Dealer> findDealerByProperty(String propertyName, Object value) {
		try{
			String querySql = "from Dealer  model where model."+propertyName+"=?";
			Query query = getSessionFactory().getCurrentSession().createQuery(querySql);
			query.setParameter(0, value);
			return query.list();
		}catch(Exception ex) {
			throw ex;
		}
	}

}
