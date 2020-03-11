package com.billing.billing;

import java.math.BigInteger;
import java.util.List;

public interface TransRepo {

	public List<BigInteger> find(int offset, int size);

	public Integer findCount();

	public void add(Transaction t);
}
