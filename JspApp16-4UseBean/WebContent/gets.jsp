<%@page import="com.nt.bean.*" %>
<!--  create or locate the bean class object -->
<jsp:useBean id="us" class="com.nt.bean.User" scope="application"/>

<jsp:getProperty  name="us" property="id"/>
<jsp:getProperty  name="us" property="name"/>
