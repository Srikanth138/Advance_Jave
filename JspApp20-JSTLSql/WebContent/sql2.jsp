<%@page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql"  prefix="sql"%>

<!-- establish the connection -->
<sql:setDataSource  var="ds" driver="oracle.jdbc.driver.OracleDriver"
                                                            url="jdbc:oracle:thin:@localhost:1521:orcl" user="scott" password="tiger"/>
<!-- exeute non-select Query -->
<sql:update dataSource="${ds}" var="count" sql="UPDATE STUDENT SET NAME=? WHERE SNO=?">
<sql:param>mahi</sql:param>
<sql:param>1005</sql:param>
</sql:update>