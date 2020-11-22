<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="msg" value="Welocme to JSTL" scope="request"/>
<c:if test="${!empty param.uname}">
<c:out value="${msg}"/>MR/Miss/Mrs.<c:out value="${param.uname}"></c:out><br/>
${msg}mr/Miss/mr.${param.uname}<br/>
</c:if>

<!-- http://localhost:3036/JspApp19-JSTLCore/core2.jsp?uname=srikanth -->
