<%@ page import="com.bx.pojo.Department" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    List<Department> departmentList =(List<Department>)session.getAttribute("dpt_list");
%>
<h3>用户注册</h3>
<form action="/employee/add" method="post">
    <div>用户名:<input type="text" name="name"></div>
    <div>性别:
        <input type="radio" name="gender" value="male">男
        <input type="radio" name="gender" value="female" checked="checked">女
    </div>
    <div>部门：
        <select name="did">
            <%
                for (Department department : departmentList) {
            %>
            <option value="<%=department.getDid()%>"><%=department.getDName()%></option>
            <%
                }
            %>
        </select>
    </div>
    <div>工资：<input type="text" name="wage"></div>
    <div><input type="submit" value="ok">submit</div>
</form>
</body>
</html>
