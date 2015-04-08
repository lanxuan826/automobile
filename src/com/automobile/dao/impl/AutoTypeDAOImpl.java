package com.automobile.dao.impl;
import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

import com.automobile.dao.AutoTypeDAO;
import com.automobile.model.AutoType;
import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;

/**
 * Home object for domain model class TAutoType.
 * @see com.AutoType.model.AutoType
 */
public class AutoTypeDAOImpl extends BaseDAOImpl implements AutoTypeDAO {
	
	
	private static final Logger log = LoggerFactory.getLogger(AutoTypeDAOImpl.class);
	// property constants
	public static final String WORD = "word";
	public static final String AutoType_VALUE = "AutoTypeValue";

	public void save(AutoType transientInstance) {
		log.debug("saving AutoType instance");
		try {
			getSessionFactory().getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(AutoType persistentInstance) {
		log.debug("deleting AutoType instance");
		try {
			getSessionFactory().getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public AutoType findById(java.lang.Integer id) {
		log.debug("getting AutoType instance with id: " + id);
		try {
			AutoType instance = (AutoType) getSessionFactory().getCurrentSession().get("com.yuqing.model.AutoType", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(AutoType instance) {
		log.debug("finding AutoType instance by example");
		try {
			List results = getSessionFactory().getCurrentSession().createCriteria("com.yuqing.model.AutoType")
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
		log.debug("finding AutoType instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from AutoType as model where model."
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

	public List findByAutoTypeValue(Object AutoTypeValue) {
		return findByProperty(AutoType_VALUE, AutoTypeValue);
	}

	public List findAll() {
		log.debug("finding all AutoType instances");
		try {
			String queryString = "from AutoType";
			Query queryObject = getSessionFactory().getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public AutoType merge(AutoType detachedInstance) {
		log.debug("merging AutoType instance");
		try {
			AutoType result = (AutoType) getSessionFactory().getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(AutoType instance) {
		log.debug("attaching dirty AutoType instance");
		try {
			getSessionFactory().getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(AutoType instance) {
		log.debug("attaching clean AutoType instance");
		try {
			getSessionFactory().getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}