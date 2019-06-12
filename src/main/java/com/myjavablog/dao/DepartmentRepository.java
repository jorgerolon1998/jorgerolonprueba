package com.myjavablog.dao;

import com.myjavablog.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long>{

    public Department findDepartmentByName(String name);
    public Department findDepartmentById(Long id);
}
