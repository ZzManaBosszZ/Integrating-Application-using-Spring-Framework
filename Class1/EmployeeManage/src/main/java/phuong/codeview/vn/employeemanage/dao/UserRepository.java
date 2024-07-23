package phuong.codeview.vn.employeemanage.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import phuong.codeview.vn.employeemanage.entity.User;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> findAllByOrderByNameAsc();
    List<User> findByNameContainingIgnoreCase(String name);
}
