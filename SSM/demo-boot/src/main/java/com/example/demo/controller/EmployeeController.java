package com.example.demo.controller;
import com.example.demo.dao.IDepartment;
import com.example.demo.dao.IEmployee;
import com.example.demo.entities.Department;
import com.example.demo.entities.Employee;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.Collection;

import java.util.HashMap;
/**
 * 员工控制层
 */
@Controller
public class EmployeeController {
    /**
     * 将员工dao注入
     */

    @Resource
    IEmployee iEmployee;
    @Resource
    IDepartment iDepartment;

    /**
     * 进入 员共列表  返回所有员工信息
     */
    @GetMapping("/emps")
    public String list(Model model){
        //调用dao获取所有员工
        Collection<Employee> employees = iEmployee.getAll();
        //将员工存储到 请求域中
        model.addAttribute("emps",employees);
        return "emp/list";
    }
    /**
     * 进入员工添加页面  顺便获取部门信息(方便 填写添加也买你)
     * 请求地址 /emp  请求方式get
     */
    @GetMapping("/insert")
    public String intoAdd(Model model){
        final Collection<Department> departments = iDepartment.getDepartments();
        model.addAttribute("depts",departments);
        return  "emp/add";
    }
/**
 * 表单提交到  /emp
 * SpringMVC自动将请求参数和入参对象的属性进行一一绑定；
 * 要求请求参数的名字和javaBean入参的对象里面的属性名是一样的
 * 员工添加
 */

@PostMapping("/add")
public  String add(Employee employee){
    //保存员工
    iEmployee.save(employee);
    //重定向到 /emps  员工列表页面
    return "redirect:/emps";
}

   /**
     * 进入员工修改页面  并保持原有信息
     * @return
    */

    @GetMapping("/find/{id}")
    public String intoUpdate(@PathVariable("id") Integer id, Model model){//路径变量的注解
        //根据 路径的id 获取 该员工
        final Employee employee = iEmployee.get(id);
        model.addAttribute("emp",employee);
        //获取 部门 信息
        final Collection<Department> departments = iDepartment.getDepartments();
        model.addAttribute("depts",departments);
        //进入 修改页面
        return "/emp/update";
    }
    /**
     * 表单信息 被 封装为 Javabean（employee）
     * 修改 员工 页面 ，保存 跳转到显示页面
     * @param employee
     * @return
     */
//    @PutMapping("/update")
    @PostMapping("/update")
    public String update(Employee employee){
        //保持修改后的信息
        iEmployee.update(employee);
        //重定向到 员工显示页面
        return "redirect:/emps";
    }
    /**
     * 删除
     * @param id
     * @return
     */
//    @PostMapping("/delete/{id}")
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id){
        iEmployee.delete(id);
        return "redirect:/emps";

    }
}
