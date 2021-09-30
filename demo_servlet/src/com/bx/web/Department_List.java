package com.bx.web;

import com.bx.pojo.Department;
import com.bx.service.DepartmentService;
import com.bx.service.Impl.DepartmentServiceImpl;
import lombok.SneakyThrows;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "Department_List" ,urlPatterns = "/department/display")
public class Department_List extends HttpServlet {
    @SneakyThrows
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DepartmentService service=new DepartmentServiceImpl();
        List<Department> departmentList=new ArrayList<>();
        departmentList=service.displayAll();

        //将所有部门信息保存到session
        HttpSession session=request.getSession();
        session.setAttribute("dpt_list",departmentList);

        //返回到指定的jsp
        response.sendRedirect("department_display.jsp");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);

    }
}
