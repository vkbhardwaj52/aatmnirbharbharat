package com.vivek.myrestapifinal.repository;

import com.vivek.myrestapifinal.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long>{

}
