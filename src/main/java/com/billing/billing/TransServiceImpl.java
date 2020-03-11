package com.billing.billing;

import java.math.BigInteger;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

@Service
public class TransServiceImpl implements TransService {

	/** the default page size */
	public static final Integer DEFAULT_PAGE_SIZE = 700;

	/** the page size */
	private Integer pageSize = DEFAULT_PAGE_SIZE;

	@Autowired
	private TransRepo repo;

	@Autowired
	private LedgerHeaderRepo ledgerHeaderRepo;

	@Autowired
	private PlatformTransactionManager txMan;

	@Override
	public void process() {

		Integer count = repo.findCount();

		Integer pages = Double.valueOf(Math.ceil(1d * count / pageSize)).intValue();

		for (int i = 0; i < pages; i++) {

			List<BigInteger> list = repo.find(i * pageSize, pageSize);

			System.out.println(list.size());

			process(list);
		}
	}

	private void process(List<BigInteger> uuids) {

		TransactionStatus tx = null;

		try {
			tx = txMan.getTransaction(
					new DefaultTransactionDefinition(DefaultTransactionDefinition.PROPAGATION_REQUIRES_NEW));
			for (BigInteger uuid : uuids) {
				LedgerHeader header = new LedgerHeader();
				header.setTransUuid(uuid);
				header.setHead("test2");
				ledgerHeaderRepo.add(header);
			}
			txMan.commit(tx);

			Thread.currentThread().sleep(2000);

		} catch (Exception e) {
			e.printStackTrace();
			txMan.rollback(tx);
		}

	}

	@Override
	@Transactional
	public void add(Transaction t) {
		repo.add(t);
	}

}
