package phuong.codeview.vn.employeemanage.service;

import java.util.List;
import phuong.codeview.vn.employeemanage.entity.Food;

public interface FoodService {
    public List<Food> findAll();

    public Food findById(int theId);

    public void save(Food theFood);

    public void deleteById(int theId);
}
