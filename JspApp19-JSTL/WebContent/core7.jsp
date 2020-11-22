<!-- To import one jsp/html file code in another jsp page/file
 it is like directive include -->
<%@ page isELIgnored="false" import="java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<b>form core7.jsp(start)</b><br/>
<c:import url="core1.jsp"/><br/>
<b>form core7.jsp ()end)</b>