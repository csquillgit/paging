package com.billing.billing;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TransRepoImpl implements TransRepo {

	@Autowired
	private EntityManager em;

	@Override
	public List<BigInteger> find(int offset, int size) {
		String query = "select id from transaction";
		Query q = em.createNativeQuery(query);
		q.setFirstResult(offset);
		q.setMaxResults(size);
		return q.getResultList();
	}

	@Override
	public Integer findCount() {
		String query = "select count(*) from transaction";
		Query q = em.createNativeQuery(query);
		BigInteger o = (BigInteger) q.getResultList().get(0);
		return o.intValue();
	}

	@Override
	public void add(Transaction t) {
		em.persist(t);
	}

}
