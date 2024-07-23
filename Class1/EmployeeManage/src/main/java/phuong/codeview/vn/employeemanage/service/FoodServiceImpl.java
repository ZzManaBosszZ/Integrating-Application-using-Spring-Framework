//package phuong.codeview.vn.employeemanage.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import phuong.codeview.vn.employeemanage.dao.FoodRepository;
//import phuong.codeview.vn.employeemanage.entity.Food;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class FoodServiceImpl implements FoodService {
//    private FoodRepository foodRepository;
//
//    @Autowired
//    public FoodServiceImpl(FoodRepository theFoodRepository) {
//        foodRepository = theFoodRepository;
//    }
//
//    @Override
//    public List<Food> findAll() {
//        return foodRepository.findAllByOrderByNameAsc();
//    }
//
//    @Override
//    public Food findById(int theId) {
//        Optional<Food> result = foodRepository.findById(theId);
//
//        Food theFood = null;
//
//        if (result.isPresent()) {
//            theFood = result.get();
//        } else {
//            throw new RuntimeException("Food not found" + theId);
//        }
//
//        return theFood;
//    }
//
//    @Override
//    public void save(Food theFood) {
//        foodRepository.save(theFood);
//    }
//
//    @Override
//    public void deleteById(int theId) {
//        foodRepository.deleteById(theId);
//    }
//}
