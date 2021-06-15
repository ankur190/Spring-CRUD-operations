package com.employee.service;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.employee.model.Employee;
import com.employee.repository.EmployeeRepository;
//defining the business logic
@Service
public class EmployeeService 
{
@Autowired
EmployeeRepository empRepository;
//getting all Employee record by using the method findaAll() of CrudRepository
public List<Employee> getAllEmployee() 
{
List<Employee> emp = new ArrayList<Employee>();
empRepository.findAll().forEach(Employee1 -> emp.add(Employee1));
return emp;
}
//getting a specific record by using the method findById() of CrudRepository
public Employee getEmployeeById(int id) 
{
return empRepository.findById(id).get();
}
//saving a specific record by using the method save() of CrudRepository
public void saveOrUpdate(Employee emp) 
{
empRepository.save(emp);
}
//deleting a specific record by using the method deleteById() of CrudRepository
public void delete(int id) 
{
empRepository.deleteById(id);
}
//updating a record
public void update(Employee emp, int bookid) 
{
empRepository.save(emp);
}
}