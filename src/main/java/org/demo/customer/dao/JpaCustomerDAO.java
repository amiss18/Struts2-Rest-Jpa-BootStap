/*
 * D.A.O. for JPA  
 * Created on 17 d�c. 2012 ( Time 14:48:56 )
 */

package org.demo.customer.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.telosys.starterkits.strutsjpa.CoreUtils;
import org.telosys.starterkits.strutsjpa.GenericJpaDao;

import org.demo.customer.bean.Customer;

public class JpaCustomerDAO extends GenericJpaDao<Customer, String> {

	private static final Predicate[] ap = {};
	
	/**
	 * Constructs a DAO for Customer
	 */
	public JpaCustomerDAO() {
		super(Customer.class);
	}
	
	/**
	 * Search by Customer example
	 */
	public List<Customer> search(final Customer element) {
		final EntityManager em = getEntityManager();
		if ( element != null  ) {
			CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
			CriteriaQuery<Customer> criteriaQuery = criteriaBuilder.createQuery(Customer.class);
			Root<Customer> from = criteriaQuery.from(Customer.class);

			List<Predicate> listP = new ArrayList<Predicate>();


			if (CoreUtils.isNotBlank(element.getCode())) {
				Predicate predicate = criteriaBuilder.equal(from.get("code"), element.getCode());
				listP.add(predicate);
			}
			if (CoreUtils.isNotBlank(element.getCountryCode())) {
				Predicate predicate = criteriaBuilder.equal(from.get("countryCode"), element.getCountryCode());
				listP.add(predicate);
			}
			if (CoreUtils.isNotBlank(element.getFirstName())) {
				Predicate predicate = criteriaBuilder.equal(from.get("firstName"), element.getFirstName());
				listP.add(predicate);
			}
			if (CoreUtils.isNotBlank(element.getLastName())) {
				Predicate predicate = criteriaBuilder.equal(from.get("lastName"), element.getLastName());
				listP.add(predicate);
			}
			if (CoreUtils.isNotBlank(element.getLogin())) {
				Predicate predicate = criteriaBuilder.equal(from.get("login"), element.getLogin());
				listP.add(predicate);
			}
			if (CoreUtils.isNotBlank(element.getPassword())) {
				Predicate predicate = criteriaBuilder.equal(from.get("password"), element.getPassword());
				listP.add(predicate);
			}
			if (CoreUtils.isNotBlank(element.getAge())) {
				Predicate predicate = criteriaBuilder.equal(from.get("age"), element.getAge());
				listP.add(predicate);
			}
			if (CoreUtils.isNotBlank(element.getCity())) {
				Predicate predicate = criteriaBuilder.equal(from.get("city"), element.getCity());
				listP.add(predicate);
			}
			if (CoreUtils.isNotBlank(element.getZipCode())) {
				Predicate predicate = criteriaBuilder.equal(from.get("zipCode"), element.getZipCode());
				listP.add(predicate);
			}
			if (CoreUtils.isNotBlank(element.getPhone())) {
				Predicate predicate = criteriaBuilder.equal(from.get("phone"), element.getPhone());
				listP.add(predicate);
			}
			if (CoreUtils.isNotBlank(element.getReviewer())) {
				Predicate predicate = criteriaBuilder.equal(from.get("reviewer"), element.getReviewer());
				listP.add(predicate);
			}
			
			criteriaQuery.where(listP.toArray(ap));
			TypedQuery<Customer> tq = em.createQuery(criteriaQuery);
			return tq.getResultList();
		}
		else
		{
    		return this.loadAll();
		}
	}

}