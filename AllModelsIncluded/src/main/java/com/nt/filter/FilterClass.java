package com.nt.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class FilterClass implements Filter {

	FilterConfig fcg;
	int i = 0;

	@Override
	public void init(FilterConfig fcg) {
		this.fcg = fcg;
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain fc) throws IOException, ServletException {
		String name = fcg.getInitParameter("fcfg");
		i = i + 1;
		System.out.println("FilterClass.doFilter()-Filter Class" + name + "," + i);
		fc.doFilter(req, res);

	}

	@Override
	public void destroy() {

	}
}
