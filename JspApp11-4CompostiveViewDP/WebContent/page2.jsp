<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<title>Java</title>
</head>

<body>
	<table border=0 width="100%" height="100%">
		<tr height="10%">
			<td colspan="3"><jsp:include page="/headerurl" /></td>
		</tr>
		<tr>
			<td width="25%"><%@include file="menu.html"%>
			</td>
			<td width="50%"><jsp:include page="java_content.jsp" /></td>
			<td width="25%">
				<table>
					<tr>
						<td><jsp:include page="weather_report.jsp" /></td>
					</tr>
					<tr>
						<td><jsp:include page="sports.jsp" /></td>
					</tr>
				</table>
			</td>
		</tr>
		<tr height="10%">
			<td colspan="3" width="100%" style="text-align: center;"><%@include
					file="footer.jsp"%></td>
		</tr>
	</table>
</body>
</html>