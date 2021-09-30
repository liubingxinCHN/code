package com.bx.dao.Impl;

import com.bx.dao.EmployeeDao;
import com.bx.pojo.Employee;
import com.bx.utils.JDBCUtils;

public class EmployeeDaoImpl implements EmployeeDao {
    @Override
    public void add(Employee employee) throws Exception {
        String sql="insert into employee values(default,?,?,?,?);";
        Object[] params={employee.getName(),employee.getGender(),
                employee.getDepartment().getDid(),employee.getWage()};
        JDBCUtils.update(sql,params);
    }
}
