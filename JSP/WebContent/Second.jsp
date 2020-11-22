<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%! public String generateWishMsg(String user){
	java.util.Calendar cal=java.util.Calendar.getInstance(); //get system date and time
	int hour=cal.get(java.util.Calendar.HOUR_OF_DAY);  //get current hour of the day
	//generete wishMsg
	if(hour<12)
		return "Good Morning::"+user;
	else if(hour<16)
		return "Good afternoon::"+user;
	else if(hour<20)
		return "Good Evening::"+user;
	else
		return "Good Night::"+user;
}
 %>
 <h2> date and time::<%= new java.util.Date() %><br></h2>
 <% String uname=request.getParameter("uname");%><br>
 <b>WISH MESSAGE IS ::</b> <%= generateWishMsg(uname)%><br> <!--  -->
 REQUEST OBJ CLASS NAME :: <%= request.getClass() %>