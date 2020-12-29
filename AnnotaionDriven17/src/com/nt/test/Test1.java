/* welcome file
 * ServletContext
 * session Mgmt
 * Security cnfg -> Still it's not Configer in Annotation
 * @WebServlet ,@WebFilter ,@WebListener ,@WebInitParam 
 * Security cfgs -> @MultipartConfig, @HttpMethodConstaint , @HttpConstraint ,@HandleTypes
*/
package com.nt.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/testurl1")
//@WebServlet(value="/testurl1")
//@WebServlet({"/testurl1","/testurl2"}) //param's are array type
//@WebServlet(value={"/testurl1","/testurl2"})
//@WebServlet(name="test" , value={"/testurl1","/testurl2"}) //name="test" logical name ->don't give same logical name on web.xml file ,it gives error.
//@WebServlet(value={"/testurl1","/testurl2"}, loadOnStartup=1)
//@WebServlet(name="test" , value={"/testurl1","/testurl2"}, loadOnStartup=1) //name="test" logical name
@WebServlet(name="test" , value={"/testurl1","/testurl2"}, loadOnStartup=1, initParams= {@WebInitParam(name="s1", value="srikanth"),@WebInitParam(name="s2", value="Patel")}) //name="test" logical name

@WebInitParam(name="s1", value="srikanth") //Init parameter => but noe it is not working
public class Test1 extends HttpServlet{
	private static final long serialVersionUID = -218307021332998098L;

	public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException {
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		
		System.out.println("Test1.doGet()");
		
		ServletConfig cfg=getServletConfig();
		
		pw.println("<b> Date and Time ::"+ new java.util.Date()+"</b><br></br>"+cfg.getServletName());
		pw.println("<br> InitParam values ::"+cfg.getInitParameter("s1")+" , "+cfg.getInitParameter("s2"));
		pw.close();
	}//doGet
	
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException {
	doGet(req,res);	
	}//doPost

}//class
