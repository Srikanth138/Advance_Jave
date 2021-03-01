<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<b>a.jsp start</b><br>
<jsp:include page="b.jsp"/><!--  -->
<%-- <jsp:include page="servlet"/>--%>

<%request.getRequestDispatcher("/serv").include(request,response);%>

<b>a.jsp end</b><br>