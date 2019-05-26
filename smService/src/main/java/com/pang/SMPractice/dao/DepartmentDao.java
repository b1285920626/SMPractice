package com.pang.SMPractice.dao;

import com.pang.SMPractice.entity.Department;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("departmentDao")
public interface DepartmentDao {
    void Insert(Department department);
    void Delete(Integer id);
    void Update(Department department);
    Department SelectById(Integer id);
    List<Department> SelectAll();
}
