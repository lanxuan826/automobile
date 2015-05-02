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

import com.automobile.dao.CustomerDAO;
import com.automobile.model.Customer;
import com.automobile.model.Customer;
import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;

/**
 * Home object for domain model class TCustomer.
 * @see com.automobile.model.Customer
 * @author Hibernate Tools
 */
public class CustomerDAOImpl extends BaseDAOImpl implements CustomerDAO {
	
	
	private static final Logger log = LoggerFactory.getLogger(CustomerDAOImpl.class);
	// property constants
	public static final String WORD = "word";
	public static final String Customer_VALUE = "CustomerValue";

	public void save(Customer transientInstance) {
		log.debug("saving Customer instance");
		try {
			getSessionFactory().getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Customer persistentInstance) {
		log.debug("deleting Customer instance");
		try {
			getSessionFactory().getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Customer findById(java.lang.Integer id) {
		log.debug("getting Customer instance with id: " + id);
		try {
			Customer instance = (Customer) getSessionFactory().getCurrentSession().get("com.yuqing.model.Customer", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Customer instance) {
		log.debug("finding Customer instance by example");
		try {
			List results = getSessionFactory().getCurrentSession().createCriteria("com.yuqing.model.Customer")
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
		log.debug("finding Customer instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Customer as model where model."
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

	public List findByCustomerValue(Object CustomerValue) {
		return findByProperty(Customer_VALUE, CustomerValue);
	}

	public List findAll() {
		log.debug("finding all Customer instances");
		try {
			String queryString = "from Customer";
			Query queryObject = getSessionFactory().getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Customer merge(Customer detachedInstance) {
		log.debug("merging Customer instance");
		try {
			Customer result = (Customer) getSessionFactory().getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Customer instance) {
		log.debug("attaching dirty Customer instance");
		try {
			getSessionFactory().getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Customer instance) {
		log.debug("attaching clean Customer instance");
		try {
			getSessionFactory().getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
	/**
	 * 通过propertyName 和 value获取customer
	 * @param propertyName
	 * @param value
	 * @return
	 */
	public List<Customer> findCustomerByProperty(String propertyName, Object value) {
		
		try{
			String querySql = "from Customer  model where model."+propertyName+"=?";
			Query query = getSessionFactory().getCurrentSession().createQuery(querySql);
			query.setParameter(0, value);
			return query.list();
		}catch(Exception ex) {
			throw ex;
		}
	}

	@Override
	public List<Customer> findCustomerByCustId(String id) {
		try{
			String querySql = "from Customer  model where model.custId=?";
			Query query = getSessionFactory().getCurrentSession().createQuery(querySql);
			query.setParameter(0, id);		
			return query.list();
		}catch(Exception ex) {
			throw ex;
		}
	}

}
