package com.xjf.springboot04webrestfulcrud.controller;

import com.xjf.springboot04webrestfulcrud.dao.DepartmentDao;
import com.xjf.springboot04webrestfulcrud.dao.EmployeeDao;
import com.xjf.springboot04webrestfulcrud.entities.Department;
import com.xjf.springboot04webrestfulcrud.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * @author xjf
 * @date 2019/1/16 11:06
 */
@Controller
public class EmployeeController {
    @Autowired
    private EmployeeDao employeeDao;
    
    @Autowired
    DepartmentDao departmentDao;

    /**
     * 获取所有员工信息
     * @param model
     * @return
     */
    @GetMapping("/emps")
    public String list(Model model){
        Collection<Employee> employees = employeeDao.getAll();
        model.addAttribute("emps",employees);

        //thymeleaf会自动拼串
        //classpath:/templates/xxx.html
        return "emp/list";
    }

    /**
     * 跳转到员工添加页面
     * @param model
     * @return
     */
    @GetMapping("/emp")
    public String toAddPage(Model model){

        //获取department信息
        Collection<Department> departments = departmentDao.getDepartments();

        model.addAttribute("depts",departments);
        return "emp/add";
    }

    /**
     * 添加员工
     * springMvc自动将请求参数和入参对象的属性进行一一绑定；
     * 要求请求参数的名字和javaBean入参的对象里面的属性名一样
     * @param employee
     * @return
     */
    @PostMapping("/emp")
    public String addEmployee(Employee employee){

        //进行添加
        employeeDao.save(employee);

        //添加成功后跳转到员工列表
        //redirect:表示重定向到一个地址   /代表当前项目路径
        //forward:表示转发一个地址
        return "redirect:/emps";
    }

    /**
     * 到编辑页面
     * @param id
     * @return
     */
    @GetMapping("/emp/{id}")
    public String toEditPage(@PathVariable("id") Integer id,Model model){
        //根据id查找员工信息
        Employee employee = employeeDao.get(id);
        model.addAttribute("emp",employee);

        //获取department信息
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);

        //添加和编辑页面二合一
        return "emp/add";
    }

    /**
     * 修改员工信息
     * @param employee
     * @return
     */
    @PutMapping("/emp")
    public String updateEmployee(Employee employee){
        //进行修改
        employeeDao.save(employee);

        //重定向到列表页面
        return "redirect:/emps";
    }

    /**
     * 删除员工
     * @param id
     * @return
     */
    @DeleteMapping("/emp/{id}")
    public String deleteEmployee(@PathVariable("id") Integer id){
        employeeDao.delete(id);

        return "redirect:/emps";
    }
}
