package com.nt.tags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class LabelTag extends  TagSupport{
	private String msg="welcome to NIT";

	public void setMsg(String msg) {   // variable name or xxx word of setXxx(-) must match with  attribute name (msg)
		this.msg = msg; //this comment error raise in test.jsp
	}

	@Override
	public int doStartTag() throws JspException {
		System.out.println("LabelTag.doStartTag()");
		JspWriter out=null; //only jsp code is display printer create
		//get Out object
		out=pageContext.getOut(); //prepared and call
		//write message browser
		try { //msg will call nit.tld
		out.print("<h1 style='color:red'>"+msg+"</h1>"); //calling the both /because out.print is there
		}
		catch(IOException ioe) {
			ioe.printStackTrace();
		}
	   return SKIP_BODY; //0=SKIP_BODY, it return to doStartTag() but it is not returne because here 0=false
	}
	
	@Override
	public int doEndTag() throws JspException {
	     System.out.println("LabelTag.doEndTag()");
	     return EVAL_PAGE; //6=EVAL_PAGE, say evaluate the remaining jsp
	}
	

}