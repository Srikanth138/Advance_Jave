<%@ page autoFlush="false" import="java.time.*"%>

<body>
	<%--Now Time IS ::
 	<%=LocalTime.now()%> --%>

	<table height="100%" width="100%">
		<tr height="10%">
			<td colspan="3" width="10%"><jsp:include page="/headerurl"
					flush="true" /></td>
		</tr>

		<tr height="80%">
			<td width="25%"><blink><%@include file="menu.html"%>
				</blink></td>
			<td width="30%"><jsp:include page="page1.jsp" flush="true" /></td>
			<td width="30%"><jsp:include page="page2.jsp" flush="true" /></td>
			<td width="30%"><jsp:include page="page3.jsp" flush="true" /></td>
			<td width="30%"><jsp:include page="page4.jsp" flush="true" /></td>
			<td width="25%"><table>
					<tr>
						<td height="12.5%" width="12.5%"><jsp:include
								page="sports.jsp" flush="true" /></td>
					</tr>
					<tr>
						<td height="12.5%" width="12.5%"><jsp:include
								page="weather_report.jsp" /></td>
					</tr>
				</table></td>
		</tr>
		<tr height="10%">
			<td colspan="3" width="10%"><%@include file="footer.jsp"%></td>
		</tr>



	</table>



</body>
