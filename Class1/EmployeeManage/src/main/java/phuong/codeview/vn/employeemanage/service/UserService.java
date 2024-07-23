package phuong.codeview.vn.employeemanage.service;

import java.util.List;
import phuong.codeview.vn.employeemanage.entity.User;

public interface UserService {
    List<User> findAll();
    User findById(int theId);
    void save(User theUser);
    void deleteById(int theId);
    List<User> searchByName(String name);
}
