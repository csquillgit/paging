package com.billing.billing;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class LedgerHeader {

	@Id
	@GeneratedValue
	private BigInteger id;

	@Column
	private String head;

	private BigInteger transUuid;

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public String getHead() {
		return head;
	}

	public void setHead(String head) {
		this.head = head;
	}

	public BigInteger getTransUuid() {
		return transUuid;
	}

	public void setTransUuid(BigInteger transUuid) {
		this.transUuid = transUuid;
	}

}
