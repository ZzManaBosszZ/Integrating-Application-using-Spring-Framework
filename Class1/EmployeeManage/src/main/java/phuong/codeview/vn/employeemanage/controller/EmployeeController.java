//package phuong.codeview.vn.employeemanage.controller;
//
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//
//import phuong.codeview.vn.employeemanage.entity.Employee;
//import phuong.codeview.vn.employeemanage.service.EmployeeService;
//
//import java.util.List;
//
//@SpringBootApplication
//@Controller
//@RequestMapping("/employees")
//public class EmployeeController {
//
//    private EmployeeService employeeService;
//
//    public EmployeeController(EmployeeService theEmployeeService) { employeeService = theEmployeeService; }
//
//    @GetMapping("/list")
//    public String listEmployees(Model theModel) {
//        List<Employee> theEmployees = employeeService.findAll();
//        theModel.addAttribute("employees", theEmployees);
//        return "list-employees";
//    }
//
//    @GetMapping("/add")
//    public String addEmployees(Model theModel) {
//        Employee theEmployees = new Employee();
//        theModel.addAttribute("employees", theEmployees);
//        return "add-employee-form";
//    }
//
//    @PostMapping("/showFormForUpdate")
//    public String showFormForUpdate(@RequestParam("employeeId") int theId,
//                                    Model theModel) {
//
//        // get the employee from the service
//        Employee theEmployee = employeeService.findById(theId);
//
//        // set employee as a model attribute to pre-populate the form
//        theModel.addAttribute("employees", theEmployee);
//
//        // send over to our form
//        return "add-employee-form";
//    }
//
//    @PostMapping("/save")
//    public String saveEmployee(@ModelAttribute("employee") Employee theEmployee) {
//
//        // save the employee
//        employeeService.save(theEmployee);
//
//        // use a redirect to prevent duplicate submissions
//        return "redirect:/employees/list";
//    }
//
//
//    @PostMapping("/delete")
//    public String delete(@RequestParam("employeeId") int theId) {
//
//        // delete the employee
//        employeeService.deleteById(theId);
//
//        // redirect to /employees/list
//        return "redirect:/employees/list";
//
//    }
//}
