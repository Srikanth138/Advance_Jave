<%@ page language="java" contentType="text/html" isThreadSafe="true" import="java.io.*, java.util.*"
	pageEncoding="UTF-8"%>
	
<%-- <%@ page @%>Directive tag are 1.case senstive  2.Unknown attributes are not allowed 3.Except import attribute, not other attributes allow to have multiple values seperated with "," symbols. 4.Except import attribute ,not other attributes to repeat with different values either in same page direct tag or multiple page directive tags.  --%> 
<!-- "page" object hold the reference of current JES class object(this)-> it is reference type is java.lang.Object and the object type is JES class. this is useful to differentiate declaration variable from  scriptlet variable when both have got same name. -->
<!-- in JES class ->java.lang.Object page=this; -->
<!-- "pageContext" obj hold multiple details about current jsp page like buffersize,autoFlush mode,session mode, error page name, req ,res, objs and etc... this useful to create attributes differnce scopes(page,req,session,application)becoz pageContext object multiple implicit objs of jsp page.. -->

<!-- pageContext object reference Type "javax.servlet.jsp.pageContext" and object type is pageContextimpl(in tomcat Server) 
in JES Class::
PageConetxt pageContext=_jspxFactory.getPageContext(this,request,response,"error.jsp",false,2048,false);

using pageContext obj, we can get access to multiple jsp implicit objs..
ServletContext application= pageContext.getServletContext();
ServeltConfig config=pageContext.getServletConfig();
JspWriter out=pageContext.getOut();
-->

<!--  isThreadSafe="true" ->specifices wheather JES class should implement "javax.servlet.SingleThreadModel"(I) or not
Note:: if Servlet comp class implementing SingleThreaddModel(I) then the underlying server takes cars of making servlet comp class obj as thread safe object.
"javax.servlet.SingleThreadModel(I) is an empty interface and also maker inteface bacoze it is making underlying server/container to provide special runtime capabilies to our servelt class obj(Impl class obj of SingleThreadModel(I).. Becoz of this ServletContainer allows one thread at a time on to servlet class obj.

Note ::Serializable , SingleThreadModel,Cloneable and etc.. are empty interfaces and also called marker interface becoz they make the underlying JVM/Server/Container to provide special runtime capabi to impl class obj.
 
 isThreadSafe="false" is ThreadSafe , isThreadSafe="true" is not threadSafe
 -->
<b>hello</b>

<%
for (int i = 0; i <= 100000; i++)
	out.println("hello" + i + "<br>");
%>

