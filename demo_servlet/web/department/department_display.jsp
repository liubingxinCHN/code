<%@ page import="java.util.List" %>
<%@ page import="com.bx.pojo.Department" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    List<Department> departmentList =(List<Department>)session.getAttribute("dpt_list");
%>
    <select>
        <%
            for (Department department : departmentList) {
        %>
        <option value="<%=department.getDid()%>"><%=department.getDName()%></option>
        <%
            }
        %>

    </select>
</body>
</html>
