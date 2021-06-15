package com.employee.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.employee.model.Employee;
import com.employee.service.EmployeeService;
//mark class as Controller
@RestController
public class EmployeeController 
{
//autowire the EmployeeService class
@Autowired
EmployeeService empService;
//creating a get mapping that retrieves all the Employee detail from the database 
@GetMapping("/employee")
private List<Employee> getAllEmployee() 
{
return empService.getAllEmployee();
}
//creating a get mapping that retrieves the detail of a specific book
@GetMapping("/employee/{empid}")
private Employee getEmployee(@PathVariable("empid") int empid) 
{
return empService.getEmployeeById(empid);
}
//creating a delete mapping that deletes a specified book
@DeleteMapping("/employee/{empid}")
private void deleteEmployee(@PathVariable("empid") int empid) 
{
empService.delete(empid);
}
//creating post mapping that post the book detail in the database
@PostMapping("/Employee")
private int saveBook(@RequestBody Employee emp) 
{
empService.saveOrUpdate(emp);
return emp.getEmpid();
}
//creating put mapping that updates the book detail 
@PutMapping("/Employee")
private Employee update(@RequestBody Employee emp) 
{
empService.saveOrUpdate(emp);
return emp;
}
}