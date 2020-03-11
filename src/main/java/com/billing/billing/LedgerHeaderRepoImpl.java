package com.billing.billing;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class LedgerHeaderRepoImpl implements LedgerHeaderRepo {

	@Autowired
	private EntityManager em;

	@Override
	public void add(LedgerHeader t) {

		em.persist(t);
	}

}
