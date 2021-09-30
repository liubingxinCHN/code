package com.bx.dao.Impl;

import com.bx.dao.DepartmentDao;
import com.bx.dao.EmployeeDao;
import com.bx.pojo.Department;
import com.bx.utils.JDBCUtils;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDaoImpl implements DepartmentDao {
    @Override
    public List<Department> displayAll() throws Exception {
        String sql="select * from department";
        ResultSet resultSet= JDBCUtils.query(sql,null);
        List<Department> departmentList=new ArrayList<>();
        while (resultSet.next()){
            Department department=new Department(resultSet.getInt("did"),resultSet.getString("dName"));
            departmentList.add(department);
        }
        return departmentList;
    }

    @Override
    public Department displayOne(Integer did) throws Exception {
        String sql="select * from department where did=?";
        Object[] params={did};
        ResultSet resultSet=JDBCUtils.query(sql,params);
        Department department=null;
        if (resultSet.next()) {
            department=new Department(resultSet.getInt("did"),resultSet.getString("dName"));
        }
        return department;
    }
}
