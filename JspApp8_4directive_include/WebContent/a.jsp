<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<b>a.jsp start</b><br>
<%@include file="b.jsp"%> <!-- directive include tag is used to call only jsp,html file NOT CALL SERVELT'S -->

<%-- <%@include file="servlet"%> --%>
<!-- direct include tag is only recognize public area file not recognize the private area files  -->
<%request.getRequestDispatcher("/servlet").include(request, response); %>
<jsp:directive.include file="b.jsp"/>
<b>a.jsp end</b><br>