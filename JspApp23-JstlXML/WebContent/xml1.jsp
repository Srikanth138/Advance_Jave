<%@ page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/xml"  prefix="x"%>

<!-- Load xml -->
<c:import url="orders.xml"  var="file"/>

<!-- parse xml file -->
<x:parse  var="do"  doc="${file}"/>

<!-- Display all orders -->
<x:forEach var="ord" select="$do/orders/order">
    <x:out select="$ord/name"/>  &nbsp; &nbsp;
    <x:out select="$ord/price"/> <br>
</x:forEach>

<hr>
<!-- Display all orders whose price>3000 -->
<x:forEach var="ord" select="$do/orders/order">
    <x:if select="$ord/price>=3000">
       <x:out select="$ord/name"/>  &nbsp; &nbsp;
        <x:out select="$ord/price"/> <br>
    </x:if>
</x:forEach>

<!-- ->Given to manipulate xml content.. that collected from files or collected from response xml
	 ->while working with Ajax/Jquery/AngularJS/Angular there is possibility of getting xml response..
	 so, to format such resonse in our page use xml tag library -->