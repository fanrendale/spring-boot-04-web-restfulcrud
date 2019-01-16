package com.xjf.springboot04webrestfulcrud.controller;

import com.xjf.springboot04webrestfulcrud.dao.EmployeeDao;
import com.xjf.springboot04webrestfulcrud.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;

/**
 * @author xjf
 * @date 2019/1/16 11:06
 */
@Controller
public class EmployeeController {
    @Autowired
    private EmployeeDao employeeDao;

    @GetMapping("/emps")
    public String list(Model model){
        Collection<Employee> employees = employeeDao.getAll();
        model.addAttribute("emps",employees);

        //thymeleaf会自动拼串
        //classpath:/templates/xxx.html
        return "emp/list";
    }
}
