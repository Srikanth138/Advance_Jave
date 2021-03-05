package com.nt.beans;

import java.io.Serializable;

public class CBeans implements Serializable {

	private String name;
	private String mailId;
	private long no;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMailId() {
		return mailId;
	}

	public void setMailId(String mailId) {
		this.mailId = mailId;
	}

	public long getNo() {
		return no;
	}

	public void setNo(long no) {
		this.no = no;
	}

	@Override
	public String toString() {
		return "CBeans [name=" + name + ", mailId=" + mailId + ", no=" + no + "]";
	}

}
