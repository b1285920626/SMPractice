package com.pang.SMPractice.service.impl;

import com.pang.SMPractice.dao.DepartmentDao;
import com.pang.SMPractice.entity.Department;
import com.pang.SMPractice.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("departmentService")
public class DepartmentServiceImpl implements DepartmentService {

    //@Autowired
    @Resource(name = "departmentDao")
    private DepartmentDao departmentDao;

    public void add(Department department) {
        departmentDao.Insert(department);
    }

    public void remove(Integer id) {
        departmentDao.Delete(id);
    }

    public void edit(Department department) {
        departmentDao.Update(department);
    }

    public Department get(Integer id) {
        return departmentDao.SelectById(id);
    }

    public List<Department> getAll() {
        return departmentDao.SelectAll();
    }
}
