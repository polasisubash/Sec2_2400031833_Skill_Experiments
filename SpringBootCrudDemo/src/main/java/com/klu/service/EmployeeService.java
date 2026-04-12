package com.klu.service;

import java.util.List;

import com.klu.model.Employee;

public interface EmployeeService {
 //creating Employee info into DB
 Employee saveEmployee(Employee e);
 //retrieveing all Employees from DB
 List<Employee> getEmployees();
 //retrieveing specific Employee based on ID from DB
 Employee getEmployee(Long id);
 //udating existed Employee based on specific ID into DB
 Employee updateEmployee(Long id,Employee e);
 //deleting existed Employee based on specific ID from DB
 String deleteEmployee(Long id);
 

}