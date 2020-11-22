<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <!-- 1. Using hyperlinks (bad)
   		 2. Using response.sendRedirect(-) method (no tag for this) (good) 
   		 sendRedirect(-) communicates any web component servlets,jsp,html,php,asp.net & etc...
   		  forward() & include() web component must be on of the following comp servlet,jsp & html. -->
   		 
<b>Start of a.jsp</b>
<br/>

<% String q="amazon";
response.sendRedirect("http://google.com/search?q="+q);%>
<br/>
<b>end of a.jsp</b>