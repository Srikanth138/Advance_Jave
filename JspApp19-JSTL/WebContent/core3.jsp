<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- To bring the effect of if..else if.. if else.. tags / To even the effect of switch - case-->

<c:choose>
 <c:when test="${param.p>0}">
 ${param.p} is positive
 </c:when>

<c:when test="${param.p<0}">
 ${param.p} is negative
 </c:when>
 <c:otherwise>
 ${param.p} is Zero
 </c:otherwise>

</c:choose>

<!-- http://localhost:3036/JspApp19-JSTLCore/core3.jsp?p=10 -->