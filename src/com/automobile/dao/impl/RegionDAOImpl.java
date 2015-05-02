package com.automobile.dao.impl;

// Generated 2015-4-7 21:58:34 by Hibernate Tools 3.2.2.GA

import java.util.List;




import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Example;

import com.automobile.dao.RegionDAO;
import com.automobile.model.Region;
import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;

public class RegionDAOImpl  extends BaseDAOImpl implements RegionDAO {
	
	
	private static final Logger log = LoggerFactory.getLogger(RegionDAOImpl.class);
	// property constants
	public static final String WORD = "word";
	public static final String Region_VALUE = "RegionValue";

	public void save(Region transientInstance) {
		log.debug("saving Region instance");
		try {
			getSessionFactory().getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Region persistentInstance) {
		log.debug("deleting Region instance");
		try {
			getSessionFactory().getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Region findById(java.lang.Integer id) {
		log.debug("getting Region instance with id: " + id);
		try {
			Region instance = (Region) getSessionFactory().getCurrentSession().get("com.yuqing.model.Region", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Region instance) {
		log.debug("finding Region instance by example");
		try {
			List results = getSessionFactory().getCurrentSession().createCriteria("com.yuqing.model.Region")
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
		log.debug("finding Region instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Region as model where model."
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

	public List findByRegionValue(Object RegionValue) {
		return findByProperty(Region_VALUE, RegionValue);
	}

	public List findAll() {
		log.debug("finding all Region instances");
		try {
			String queryString = "from Region";
			Query queryObject = getSessionFactory().getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
	public List<Region> showRegionListAll() {
		log.debug("finding all Region instances");
		try {
			String queryString = "from Region";
			Session session = getSessionFactory().getCurrentSession();
			Query queryObject = session.createQuery(queryString);
//			Query queryObject = getSessionFactory().getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
	


	public Region merge(Region detachedInstance) {
		log.debug("merging Region instance");
		try {
			Region result = (Region) getSessionFactory().getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Region instance) {
		log.debug("attaching dirty Region instance");
		try {
			getSessionFactory().getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Region instance) {
		log.debug("attaching clean Region instance");
		try {
			getSessionFactory().getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Region> showProviceList() {

		log.debug("finding Provice instances");
		try {
			String queryString = "from Region r where r.fatherId=0";
			Query queryObject = getSessionFactory().getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find Provice failed", re);
			throw re;
		}
	}

	@Override
	public List<Region> getRegionInfoByProvice(Region instance) {
		log.debug("finding RegionInfoByProvice instances");
		try {
			String queryString = "from Region r where r.fatherId="+instance.getFatherId();
			Query queryObject = getSessionFactory().getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find RegionInfoByProvice failed", re);
			throw re;
		}
	}

	

}
