package phuong.codeview.vn.employeemanage.controller;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import phuong.codeview.vn.employeemanage.entity.Food;
import phuong.codeview.vn.employeemanage.service.FoodService;

import java.util.List;

@SpringBootApplication
@Controller
@RequestMapping("/foods")
public class FoodController {

    private FoodService foodService;

    public FoodController(FoodService theFoodService) { foodService = theFoodService; }

    @GetMapping("/list")
    public String listFoods(Model theModel) {
        List<Food> theFoods = foodService.findAll();
        theModel.addAttribute("foods", theFoods);
        return "food/list-food";
    }

    @GetMapping("/add")
    public String addFoods(Model theModel) {
        Food theFoods = new Food();
        theModel.addAttribute("foods", theFoods);
        return "food/food-form";
    }

    @PostMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("foodId") int theId,
                                    Model theModel) {

        // get the employee from the service
        Food theFood = foodService.findById(theId);

        // set employee as a model attribute to pre-populate the form
        theModel.addAttribute("foods", theFood);

        // send over to our form
        return "food/food-form";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("food") Food theFood) {

        // save the employee
        foodService.save(theFood);

        // use a redirect to prevent duplicate submissions
        return "redirect:/foods/list";
    }


    @PostMapping("/delete")
    public String delete(@RequestParam("foodId") int theId) {

        // delete the employee
        foodService.deleteById(theId);

        // redirect to /employees/list
        return "redirect:/foods/list";

    }
}
