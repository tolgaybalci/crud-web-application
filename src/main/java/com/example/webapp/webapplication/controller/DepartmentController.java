package com.example.webapp.webapplication.controller;

import com.example.webapp.webapplication.domain.Department;
import com.example.webapp.webapplication.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/departments")
public class DepartmentController {

    @Autowired
    private DepartmentRepository departmentRepository;

    @GetMapping("")
    public String getDepartmentList(Model model){
        model.addAttribute("departments", departmentRepository.findAll());
        return "departments/departmentList";
    }

    @GetMapping("/new")
    public String getNewDepartment(Model model){
        model.addAttribute("department", new Department());
        return "departments/newDepartment";
    }

    @PostMapping("/new")
    public String postNewDepartment(@ModelAttribute Department department){
        departmentRepository.save(department);
        return "redirect:/departments";
    }

    @GetMapping("/{id}")
    public String getShowDepartment(@PathVariable Long id, Model model){
        model.addAttribute("department", departmentRepository.findOne(id));
        return "departments/showDepartment";
    }

    @GetMapping("/{id}/update")
    public String getUpdateDepartment(@PathVariable Long id, Model model){
        model.addAttribute("department", departmentRepository.findOne(id));
        return "departments/updateDepartment";
    }

    @PostMapping("/{id}/update")
    public String postUpdateDepartment(@ModelAttribute Department department){
        departmentRepository.save(department);
        return "redirect:/departments";
    }
}
