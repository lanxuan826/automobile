package com.automobile.dao.impl;

import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

import com.automobile.dao.AutoMobileDAO;
import com.automobile.model.AutoMobile;
import com.automobile.model.AutoType;
import com.opensymphony.xwork2.util.logging.Logger;	
import com.opensymphony.xwork2.util.logging.LoggerFactory;

public class AutoMobileDAOImpl extends BaseDAOImpl implements AutoMobileDAO {
	
	
	private static final Logger log = LoggerFactory.getLogger(AutoMobileDAOImpl.class);
	// property constants
	public static final String WORD = "word";
	public static final String AutoMobile_VALUE = "AutoMobileValue";

	public void save(AutoMobile transientInstance) {
		log.debug("saving AutoMobile instance");
		try {
			getSessionFactory().getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(AutoMobile persistentInstance) {
		log.debug("deleting AutoMobile instance");
		try {
			getSessionFactory().getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public AutoMobile findById(java.lang.Integer id) {
		log.debug("getting AutoMobile instance with id: " + id);
		try {
			AutoMobile instance = (AutoMobile) getSessionFactory().getCurrentSession().get("com.yuqing.model.AutoMobile", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(AutoMobile instance) {
		log.debug("finding AutoMobile instance by example");
		try {
			List results = getSessionFactory().getCurrentSession().createCriteria("com.yuqing.model.AutoMobile")
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
		log.debug("finding AutoMobile instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from AutoMobile as model where model."
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

	public List findByAutoMobileValue(Object AutoMobileValue) {
		return findByProperty(AutoMobile_VALUE, AutoMobileValue);
	}

	public List findAll() {
		log.debug("finding all AutoMobile instances");
		try {
			String queryString = "from AutoMobile";
			Query queryObject = getSessionFactory().getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public AutoMobile merge(AutoMobile detachedInstance) {
		log.debug("merging AutoMobile instance");
		try {
			AutoMobile result = (AutoMobile) getSessionFactory().getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(AutoMobile instance) {
		log.debug("attaching dirty AutoMobile instance");
		try {
			getSessionFactory().getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(AutoMobile instance) {
		log.debug("attaching clean AutoMobile instance");
		try {
			getSessionFactory().getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	@Override
	public List<AutoMobile> getAutoInfoByType(AutoType autoType) {
		log.debug("finding  AutoMobile by type  instances");
		try {
			String queryString = "from AutoMobile a where a.autoTypeId = '"+autoType.getAutoTypeId()+"'";
			System.out.println("============="+queryString);
			Query queryObject = getSessionFactory().getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
}
	
