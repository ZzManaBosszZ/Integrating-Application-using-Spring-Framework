package phuong.codeview.vn.firstclassproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
@Controller
public class GreetingController {
    public static void main(String[] args) {SpringApplication.run(GreetingController.class, args);}

    @GetMapping("/greeting")
    public String sayHello(@RequestParam(name = "name", required = false, defaultValue = "World") String name, Model model){
        model.addAttribute("name", name);
        return "greeting";
    }
}
