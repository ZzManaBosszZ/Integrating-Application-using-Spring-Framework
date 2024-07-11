package phuong.codeview.vn.thymeleafbootstrap.controller;

import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;

import phuong.codeview.vn.thymeleafbootstrap.model.Employee;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private List<Employee> theEmployees;

    @PostConstruct
    private void loadData() {

        Employee emp1 = new Employee(1, "Phuong", "Hoang", "phuongphuong2004@gmail.com");
        Employee emp2 = new Employee(2, "Han", "Nam", "phuongphuong2004@gmail.com");
        Employee emp3 = new Employee(3, "Hung", "Lan", "phuongphuong2004@gmail.com");

        theEmployees = new ArrayList<Employee>();

        theEmployees.add(emp1);
        theEmployees.add(emp2);
        theEmployees.add(emp3);
    }

    @GetMapping("/list")
    public String listEmployees(Model model) {
        model.addAttribute("employees", theEmployees);
        return "list-employees";
    }
}
