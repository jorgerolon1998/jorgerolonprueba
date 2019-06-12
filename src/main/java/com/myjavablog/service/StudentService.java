package com.myjavablog.service;

import com.myjavablog.model.Student;

import java.util.List;

public interface StudentService {

    public void saveStudent(List<Student> studentList);

    public List<Student> getStudents();

}