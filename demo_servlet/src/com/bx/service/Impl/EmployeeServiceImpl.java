package com.bx.service.Impl;

import com.bx.dao.EmployeeDao;
import com.bx.dao.Impl.EmployeeDaoImpl;
import com.bx.pojo.Employee;
import com.bx.service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeDao dao;

    public EmployeeServiceImpl() {
        dao=new EmployeeDaoImpl();
    }

    @Override
    public void add(Employee employee) throws Exception {
        dao.add(employee);
    }
}
