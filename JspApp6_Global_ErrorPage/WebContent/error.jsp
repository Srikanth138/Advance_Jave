<%@ page isErrorPage="true"%>
<b>error.jsp</b>
<br/>
<b><i>Internal problem -- Try again</i></b>
<hr>
<%=exception.toString() %>

<!-- we can take HTML file as error page. but we can not use the implicit object "exception" in it. -->