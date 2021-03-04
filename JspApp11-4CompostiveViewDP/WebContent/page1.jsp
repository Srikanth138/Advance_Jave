<%@ page autoFlush="false" import="java.time.*"%>

<body>
	<table height="100%" width="100%">
		<tr height="10%">
			<td colspan="3" width="100%"><jsp:include page="/headerurl"
					flush="true"/></td>
		</tr>

		<tr height="80%">
			<td width="25%"><%@include file="menu.html"%></td>
			<td width="50%"><jsp:include page="welcome.jsp" /></td>
			
			<td width="25%">
				<table>
					<tr>
						<td><jsp:include page="sports.jsp" flush="true" /></td>
					</tr>
					<tr>
						<td><jsp:include page="weather_report.jsp" /></td>
					</tr>
				</table>
			</td>
		</tr>
		
		<tr height="10%">
			<td colspan="3" width="100%" style="text-align: center;"><%@include file="footer.jsp"%></td>
		</tr>
	</table>
</body>
