package com.myjavablog.controller;

import com.myjavablog.model.Department;
import com.myjavablog.model.Student;
import com.myjavablog.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    @PostMapping("/saveDept")
    public String saveDepartment(@RequestBody Department department){
        departmentService.saveDepartment(department);
        return "Saved successfully...";
    }

    @RequestMapping(value = "/departmentList", method = RequestMethod.GET)
    public @ResponseBody List<Department> getDepartments(){
        return departmentService.getDepartments();
    }

}
