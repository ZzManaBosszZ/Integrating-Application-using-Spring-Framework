package com.restaurant.t2209m_nguyenhoangphuong.controller;

import com.restaurant.t2209m_nguyenhoangphuong.entities.Student;
import com.restaurant.t2209m_nguyenhoangphuong.entities.StudentScore;
import com.restaurant.t2209m_nguyenhoangphuong.entities.Subject;
import com.restaurant.t2209m_nguyenhoangphuong.repository.StudentRepository;
import com.restaurant.t2209m_nguyenhoangphuong.repository.StudentScoreRepository;
import com.restaurant.t2209m_nguyenhoangphuong.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
@Controller
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private StudentScoreRepository studentScoreRepository;
    @Autowired
    private SubjectRepository subjectRepository;

    @GetMapping
    public String listStudents(Model model) {
        List<Student> students = studentRepository.findAll();
        List<StudentScore> scores = studentScoreRepository.findAll();
        model.addAttribute("students", students);
        model.addAttribute("scores", scores);
        return "students/list"; // This corresponds to the Thymeleaf template
    }

    @GetMapping("/add")
    public String showAddStudentForm(Model model) {
        model.addAttribute("student", new Student());
        return "students/add";
    }

    @PostMapping("/add")
    public String addStudent(@ModelAttribute Student student) {
        studentRepository.save(student);
        return "redirect:/students";
    }

    @GetMapping("/{id}/edit")
    public String editStudent(@PathVariable Integer id, Model model) {
        Student student = studentRepository.getReferenceById(id);
        model.addAttribute("student", student);
        return "students/edit";
    }

    @PostMapping("/{id}/update")
    public String updateStudent(@PathVariable Integer id, @ModelAttribute Student student) {
        student.setStudentId(id);
        studentRepository.save(student);
        return "redirect:/students";
    }

    @GetMapping("/{id}/delete")
    public String deleteStudent(@PathVariable Integer id) {
        studentRepository.delete(studentRepository.getReferenceById(id));
        return "redirect:/students";
    }
}
