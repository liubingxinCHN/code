package com.bx.web;

import com.bx.pojo.Department;
import com.bx.pojo.Employee;
import com.bx.service.EmployeeService;
import com.bx.service.Impl.EmployeeServiceImpl;
import lombok.SneakyThrows;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Employee_Servlet",urlPatterns = "/employee/add")
public class Employee_Add extends HttpServlet {
    @SneakyThrows
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EmployeeService employeeService=new EmployeeServiceImpl();

        request.setCharacterEncoding("utf-8");
        String name=request.getParameter("name");
        String[] gender=request.getParameterValues("gender");
        Integer did=Integer.parseInt(request.getParameter("did"));
        Integer wage=Integer.parseInt(request.getParameter("wage"));
        Department department=new Department(did,"");
        Employee employee=new Employee(-1,name,gender[0],did,department);
        employeeService.add(employee);
        response.sendRedirect("../index.jsp");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
