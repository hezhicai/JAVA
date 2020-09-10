package com.example.demojdbc.controller;

import com.example.demojdbc.bean.Student;
import com.example.demojdbc.mapper.IStudent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class StudentController {

    @Resource
    IStudent istudent;

    @ResponseBody
    @GetMapping("/insert2")
    public Student insert(){
        Student student=new Student();
        student.setSno("2008");
        student.setName("xiaohu");
        student.setSex("女");
        istudent.insert(student);
        return  student;
    }
}
