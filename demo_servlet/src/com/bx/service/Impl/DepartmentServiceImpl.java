package com.bx.service.Impl;

import com.bx.dao.DepartmentDao;
import com.bx.dao.Impl.DepartmentDaoImpl;
import com.bx.pojo.Department;
import com.bx.service.DepartmentService;

import java.util.List;

public class DepartmentServiceImpl implements DepartmentService {
    private DepartmentDao dao;

    public DepartmentServiceImpl() {
        dao = new DepartmentDaoImpl();
    }

    @Override
    public List<Department> displayAll() throws Exception {
        return dao.displayAll();
    }

    @Override
    public Department displayOne(Integer did) throws Exception {
        return dao.displayOne(did);
    }
}
