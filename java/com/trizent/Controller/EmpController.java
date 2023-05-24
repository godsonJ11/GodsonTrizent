package com.trizent.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.trizent.Model.Employee;
import com.trizent.Repository.EmpRepos;

@RestController
public class EmpController {
	
	@Autowired
	private EmpRepos emprepos;
	
	
	@PostMapping("/godson")
	public  String saveEmp(@RequestBody Employee employee) {
		 boolean emailExists = emprepos.existsByEemail(employee.getEemail());
		 if(emailExists) {
			return "email already taken"; 
		 }
		emprepos.save(employee);
		return "Save successfully" ;
	}
	@GetMapping("/godson")
	public List<Employee> getEmp(){ 
		return emprepos.findAll();		
	}
	@GetMapping("/godson/{eemail}")
	public Optional<Employee> getEmployee(@PathVariable("eemail")String eemail) {
		return emprepos.findById(eemail);
	}
	@PutMapping("/godson")
	public Employee updateEmp( @RequestBody Employee employee) {
		emprepos.save(employee);
		return  employee;
    }
	@DeleteMapping("/godson/{eemail}")
	public String deleteEmp(@PathVariable("eemail")String eemail) {
		@SuppressWarnings("deprecation")
		Employee employee=emprepos.getOne(eemail) ;
		emprepos.delete(employee);
		return "Deleted successfuly";
	}
	@GetMapping("/godson/emp/{eage}")
	public Optional<Employee> getEmp(@PathVariable ("eage") int eage){
		return emprepos.findByEage(eage);
	}
	@GetMapping("/godson/emp/get/{eage}")
	public List<Employee>getByAge(@PathVariable("eage") int eage){
		return emprepos.findByEageGreaterThan(eage);
	}
	@GetMapping("/godson/employee/{nameprefix}")
	public List<Employee> getByname(@PathVariable   String nameprefix){
		return emprepos.findByEnameIsStartingWith(nameprefix);
	}
}
