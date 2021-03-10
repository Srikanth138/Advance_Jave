<%@page import="com.nt.bean.*" %>
<!--  create or locate the bean class object -->
<jsp:useBean id="us" class="com.nt.bean.User" scope="application"/>

<!-- 1.name : "object name", this "id" property value given in <Jsp:useBean> tag
 2. property : bean property name,xxx word of setXXX(-) method
 3. value: bean property value
 4. param : request param name whose values can be assigned as the property value
 NOTE :we can use either "value" (or)" param at atime" -->
 

<!-- set the values  to the bean properties -->
<%-- <jsp:setProperty property="id" name="us" value="100" /> 
<jsp:setProperty property="name" name="us" value="srikanth"/> --%>

<!-- set the values form param name's -->
<jsp:setProperty property="id" name="us" param="uid" /> 
<jsp:setProperty property="name" name="us" param="uname" />

<!-- http://localhost:3036/JspApp16-4UseBean/sets.jsp?uid=101&uname=sri 
http://localhost:3036/JspApp16-4UseBean/sets.jsp?uname=sri&uid=101
http://localhost:3036/JspApp16-4UseBean/sets.jsp?uname=sri
http://localhost:3036/JspApp16-4UseBean/sets.jsp?uid=101
 -->



<b> values are setted to the user properies </b>
