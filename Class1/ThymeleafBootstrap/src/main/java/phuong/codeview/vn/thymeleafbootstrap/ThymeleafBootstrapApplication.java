package phuong.codeview.vn.thymeleafbootstrap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
@Controller
public class ThymeleafBootstrapApplication {

	public static void main(String[] args) {
		SpringApplication.run(ThymeleafBootstrapApplication.class, args);
	}

}
