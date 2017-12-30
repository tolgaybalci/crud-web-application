package com.example.webapp.webapplication.controller;

import com.example.webapp.webapplication.domain.Student;
import com.example.webapp.webapplication.repository.DepartmentRepository;
import com.example.webapp.webapplication.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @GetMapping("")
    public String getStudentList(Model model){
        model.addAttribute("students", studentRepository.findAll());
        return "students/studentList";
    }

    @GetMapping("/new")
    public String getNewStudent(Model model){
        model.addAttribute("student", new Student());
        model.addAttribute("departments",departmentRepository.findAll());
        return "students/newStudent";
    }

    @PostMapping("/new")
    public String postNewStudent(@ModelAttribute Student student){
        studentRepository.save(student);
        return "redirect:/students";
    }

    @GetMapping("/{id}")
    public String getShowStudent(@PathVariable Long id, Model model){
        model.addAttribute("student", studentRepository.findOne(id));
        return "students/showStudent";
    }

    @GetMapping("/{id}/update")
    public String getUpdateStudent(@PathVariable Long id, Model model){
        model.addAttribute("student", studentRepository.findOne(id));
        return "students/updateStudent";
    }

    @PostMapping("/{id}/update")
    public String postUpdateStudent(@ModelAttribute Student student){
        studentRepository.save(student);
        return "redirect:/updateStudent";
    }
}
