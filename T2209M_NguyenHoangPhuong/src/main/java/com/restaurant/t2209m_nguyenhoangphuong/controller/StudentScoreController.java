package com.restaurant.t2209m_nguyenhoangphuong.controller;

import com.restaurant.t2209m_nguyenhoangphuong.entities.Student;
import com.restaurant.t2209m_nguyenhoangphuong.entities.StudentScore;
import com.restaurant.t2209m_nguyenhoangphuong.entities.Subject;
import com.restaurant.t2209m_nguyenhoangphuong.repository.StudentRepository;
import com.restaurant.t2209m_nguyenhoangphuong.repository.StudentScoreRepository;
import com.restaurant.t2209m_nguyenhoangphuong.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/scores")
public class StudentScoreController {

    @Autowired
    private StudentScoreRepository studentScoreRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private SubjectRepository subjectRepository;

    @GetMapping("/add")
    public String showAddScoreForm(Model model) {
        model.addAttribute("studentScore", new StudentScore());
        model.addAttribute("students", studentRepository.findAll());
        model.addAttribute("subjects", subjectRepository.findAll());
        return "students/score/add";
    }

    @PostMapping("/add")
    public String addScore(@ModelAttribute("studentScore") StudentScore studentScore) {
        // Find the student and subject by ID
        Student student = studentRepository.findById(studentScore.getStudent().getStudentId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid student ID: " + studentScore.getStudent().getStudentId()));
        Subject subject = subjectRepository.findById(studentScore.getSubject().getSubjectId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid subject ID: " + studentScore.getSubject().getSubjectId()));

        // Set the student and subject to the studentScore
        studentScore.setStudent(student);
        studentScore.setSubject(subject);

        // Save the studentScore to the database
        studentScoreRepository.save(studentScore);

        // Redirect to the students list page
        return "redirect:/students";
    }
}
