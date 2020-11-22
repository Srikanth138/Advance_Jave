<%@ page buffer="2kb" autoFlush="flase" session="false" %> 
<!-- what is buffer :- at run time create a memory to excution. autoFlush:-id the refresh the execution  --> 
<!-- buffer="none" is and autoFlush="false" there raise Exception-->
<!-- session="true" the session is reflected in _JES class -->
<!--page buffer="2kb" autoFlush="true" by defalut  buffer is fill on 2kb data error is come no autoFlush is not work  -->

<%
for(int i=0;i<=1000000;i++){
	if(i%200==0)                //every 100 times buffer is flush
out.println("hello"+i);
}%>
