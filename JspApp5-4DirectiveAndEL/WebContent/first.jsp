<%@ page language="java" isELIgnored="false" session="true" import="java.util.Date"  contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!-- extends="com.nt.beans.Test" -->

<!-- page Attributes are the import,session,extends,isELIgnored,language,contextType -->
<% Date d=new Date(); 
out.print(d);%>
<br>

<!-- isELIgnored="false" ${4+5}=9  ,isELIgnored="true" ${4+5}=${4+5} -->
${4+5}