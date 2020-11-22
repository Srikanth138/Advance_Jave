<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- jstl is introduce sun micros / implemented by the tomcat-->
<!-- http://localhost:3036/JspApp19-JSTL/core4.jsp?p=5 -->
<!-- ${param.p} =>take run time value -->

<!-- Tradtion for loop -->
<table border="1" align="center" bgcolor="cyan">
<c:forEach var="i" begin="1" end="10" step="1">
<tr> 
<td>${param.p}*${i}=</td> <td>${param.p*i}</td>
</c:forEach>
</table>
<br/>
<jsp:scriptlet>
String studNames[]={"raja","rani","suresh","mahesh"};
request.setAttribute("namesArray",studNames);
</jsp:scriptlet>

<!-- Enhanced for loop -->
<c:forEach var="name" items="${namesArray}">
${name}<br/>
</c:forEach>

<!-- (<) symbel shows error be cause CDATA -->
<!--  List<Long> phoneList=List.of(9999999L,88888888l,77777777l); //java9 
<jsp:scriptlet>
<![CDATA[
//List<long> phoneList=new ArrayList<long>(9999999L,88888888l,77777777l); 
//request.setAttribute("phoneInfo",phoneList);
]]>
</jsp:scriptlet>  -->

<!-- Enhance for Loop -->
<!-- <c:forEach value="ph" items="${phoneinfo}"> -->
<!-- ${ph}<br>  -->
<!-- </c:forEach>  -->