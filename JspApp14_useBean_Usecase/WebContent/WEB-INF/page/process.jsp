<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>

    <!--  create or Locate DTO class object to/form request scope -->
     <jsp:useBean id="to"  class="com.pack.Dto.EmployeeDTO"  scope="request"/>
     
     <!-- write form data to DTO class object -->
     <jsp:setProperty name="to"  property="*"/>
     
     <!-- create/locate Service class object  *here create the object-->
     <jsp:useBean id="Service"  
                                class="com.pack.service.EmployeeMgmtServiceImpl"
                                 type="com.pack.service.EmployeeMgmtService"
                                 scope="application"/>
    <%
        Service.generateSalaryDetails(to);
    %>      
    <table border="2" align="Center" bgcolor="green">                          
     <tr> <td colspan="2" align="Center"><b><i>  Employee Details Are </i></b></td></tr>
         <tr><td> employee id::    </td> <td> <jsp:getProperty property="eid" name="to"/>  </td> </tr>    
         <tr><td> employee name::	</td> <td>  <jsp:getProperty property="ename" name="to"/>  </td> </tr>    
         <tr><td> employee basicSalary:: </td> <td> <jsp:getProperty property="basicSalary" name="to"/>   </td> </tr>  
         <tr><td> employee grossSalary:: </td> <td> <jsp:getProperty property="grossSalary" name="to"/>  </td> </tr>
         <tr><td> employee netSalary::  </td> <td><jsp:getProperty property="netSalary" name="to"/>     </td> </tr>
         
          </table> 
          <br>
          <a href="form.html">home</a>