package com.bx.service;

import com.bx.pojo.Department;

import java.util.List;

public interface DepartmentService{
    //获取所有部门的信息
    public List<Department> displayAll() throws Exception;

    //根据Id获取对应的部门信息
    public Department displayOne(Integer did) throws Exception;

}
