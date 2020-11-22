<!-- Given for catching and handling exception -->
<%@ page isELIgnored="false" import="java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:catch var="e">
<jsp:scriptlet>
int x=Integer.parseInt("10");
</jsp:scriptlet>
x value::<jsp:expression>x</jsp:expression>
</c:catch>
<c:if test="${e ne null}">
<b>the taised exception is::${e}</b>
</c:if>