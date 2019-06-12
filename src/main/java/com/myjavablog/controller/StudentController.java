package com.myjavablog.controller;

import com.myjavablog.dao.DepartmentRepository;
import com.myjavablog.dao.StudentRepository;
import com.myjavablog.model.Department;
import com.myjavablog.model.Student;
import com.myjavablog.service.DepartmentService;
import com.myjavablog.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    @Autowired
    DepartmentService departmentService;

    @RequestMapping(value = "/studentList", method = RequestMethod.GET)
    public @ResponseBody List<Student> getStudents(){
        return studentService.getStudents();
    }

    @PostMapping("/saveStudent/{deptName}")
    public String saveStudent(@RequestBody List<Student> studentList, @PathVariable String deptName){
        try {
            Department dept = departmentService.findDepartment(deptName.toUpperCase());

            for(Student student: studentList)
                student.setDepartment(dept);

            studentService.saveStudent(studentList);
            return "Student saved successfully..";
        }catch (Exception ex){
            ex.printStackTrace();
            return "Error in saving Student ..";
        }
    }
}
