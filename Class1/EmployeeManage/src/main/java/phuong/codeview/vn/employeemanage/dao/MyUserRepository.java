package phuong.codeview.vn.employeemanage.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import phuong.codeview.vn.employeemanage.entity.myUser;

import java.util.Optional;

public interface MyUserRepository extends JpaRepository<myUser, Integer> {

    Optional<myUser> findByUsername(String username);
}
