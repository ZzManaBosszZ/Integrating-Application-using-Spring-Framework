package phuong.codeview.vn.employeemanage.service;

import java.util.List;
import phuong.codeview.vn.employeemanage.entity.Employee;

public interface EmployeeService {

    public List<Employee> findAll();

    public Employee findById(int theId);

    public void save(Employee theEmployee);

    public void deleteById(int theId);
}
