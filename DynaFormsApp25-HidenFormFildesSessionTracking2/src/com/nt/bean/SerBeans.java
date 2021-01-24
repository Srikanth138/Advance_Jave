package com.nt.bean;

import java.io.Serializable;

public class SerBeans implements Serializable {

	private String name;
	private String father;
	private String ms;
	private String f2val1;
	private String f2val2;

	public SerBeans() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFather() {
		return father;
	}

	public void setFather(String father) {
		this.father = father;
	}

	public String getMs() {
		return ms;
	}

	public void setMs(String ms) {
		this.ms = ms;
	}

	public String getF2val1() {
		return f2val1;
	}

	public void setF2val1(String f2val1) {
		this.f2val1 = f2val1;
	}

	public String getF2val2() {
		return f2val2;
	}

	public void setF2val2(String f2val2) {
		this.f2val2 = f2val2;
	}

	@Override
	public String toString() {
		return "SerBeans [name=" + name + ", father=" + father + ", ms=" + ms + ", f2val1=" + f2val1 + ", f2val2="
				+ f2val2 + "]";
	}

}
