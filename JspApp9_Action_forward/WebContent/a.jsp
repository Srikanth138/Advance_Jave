<%@ page language="java" contentType="text/html; "%>
<b>Start of a.jsp</b>
<br/>
<%float bAmt=300.0f+(300.0f*0.03f); %>
<br>
<jsp:forward page="b.jsp">
<jsp:param value="CRJ" name="bkName"/>
<jsp:param value="<%=bAmt%>" name="billAmt"/>
</jsp:forward>
<br/>
<b>end of a.jsp</b>