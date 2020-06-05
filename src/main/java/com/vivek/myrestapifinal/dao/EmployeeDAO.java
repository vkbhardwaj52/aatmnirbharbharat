package com.vivek.myrestapifinal.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vivek.myrestapifinal.model.Employee;
import com.vivek.myrestapifinal.repository.EmployeeRepository;

@Service
public class EmployeeDAO {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	
	//Save an employee	
	public Employee save(Employee emp)
	{
		return employeeRepository.save(emp);
	}
	
	
	//Search all employee
	public List<Employee> findAll()
	{
		return employeeRepository.findAll();
	}
	
	
	//Get an employee
	public Employee findOne(Long empid)
	{
		return employeeRepository.findOne(empid);
	}
	
	
	//delete an employee
	public void delete(Employee emp)
	{
		employeeRepository.delete(emp);
	}

}
