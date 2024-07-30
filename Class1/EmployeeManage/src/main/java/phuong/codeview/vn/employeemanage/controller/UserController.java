package phuong.codeview.vn.employeemanage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import phuong.codeview.vn.employeemanage.dao.MyUserRepository;
import phuong.codeview.vn.employeemanage.entity.User;
import phuong.codeview.vn.employeemanage.entity.myUser;
import phuong.codeview.vn.employeemanage.service.UserService;

import java.util.List;

@SpringBootApplication
@Controller
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    public UserController(UserService theUserService) {
        userService = theUserService;
    }

    @GetMapping("/list")
    public String listUsers(Model theModel) {
        List<User> theUsers = userService.findAll();
        theModel.addAttribute("users", theUsers);
        return "user/list-user";
    }

    @GetMapping("/add")
    public String addUser(Model theModel) {
        User theUser = new User();
        theModel.addAttribute("user", theUser);
        return "user/user-form";
    }

    @PostMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("userId") int theId, Model theModel) {
        User theUser = userService.findById(theId);
        theModel.addAttribute("user", theUser);
        return "user/user-form";
    }


    @PostMapping("/save")
    public String saveUser(@ModelAttribute("user") User theUser) {
        userService.save(theUser);
        return "redirect:/users/list";
    }

    @PostMapping("/delete")
    public String deleteUser(@RequestParam("userId") int theId) {
        userService.deleteById(theId);
        return "redirect:/users/list";
    }

    @GetMapping("/search")
    public String search(@RequestParam("name") String name, Model theModel) {
        if (name.trim().isEmpty()) {
            return "redirect:/users/list";
        } else {
            List<User> theUsers = userService.searchByName(name);
            theModel.addAttribute("users", theUsers);
            return "user/list-user";
        }
    }

}
