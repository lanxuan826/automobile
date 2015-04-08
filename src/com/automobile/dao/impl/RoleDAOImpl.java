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

import com.automobile.dao.RoleDAO;
import com.automobile.model. Role;
import com.automobile.model.Role;
import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;

/**
 * Home object for domain model class TRole.
 * @see com.automobile.model.TRole
 * @author Hibernate Tools
 */
public class RoleDAOImpl extends BaseDAOImpl implements  RoleDAO {
	
	
	private static final Logger log = LoggerFactory.getLogger( RoleDAOImpl.class);
	// property constants
	public static final String WORD = "word";
	public static final String  Role_VALUE = " RoleValue";

	public void save( Role transientInstance) {
		log.debug("saving  Role instance");
		try {
			getSessionFactory().getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete( Role persistentInstance) {
		log.debug("deleting  Role instance");
		try {
			getSessionFactory().getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public  Role findById(java.lang.Integer id) {
		log.debug("getting  Role instance with id: " + id);
		try {
			 Role instance = ( Role) getSessionFactory().getCurrentSession().get("com.yuqing.model. Role", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample( Role instance) {
		log.debug("finding  Role instance by example");
		try {
			List results = getSessionFactory().getCurrentSession().createCriteria("com.yuqing.model. Role")
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
		log.debug("finding  Role instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from  Role as model where model."
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

	public List findByRoleValue(Object  RoleValue) {
		return findByProperty( Role_VALUE,  RoleValue);
	}

	public List findAll() {
		log.debug("finding all  Role instances");
		try {
			String queryString = "from  Role";
			Query queryObject = getSessionFactory().getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public  Role merge( Role detachedInstance) {
		log.debug("merging  Role instance");
		try {
			 Role result = ( Role) getSessionFactory().getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty( Role instance) {
		log.debug("attaching dirty  Role instance");
		try {
			getSessionFactory().getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean( Role instance) {
		log.debug("attaching clean  Role instance");
		try {
			getSessionFactory().getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}