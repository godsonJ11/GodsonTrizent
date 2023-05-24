package com.trizent.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trizent.Model.Employee;

import java.util.List;
import java.util.Optional;


public interface EmpRepos extends JpaRepository<Employee,String> {
	  Optional<Employee> findByEage(int eage);
	  List <Employee> findByEageGreaterThan(int eage);
	  List<Employee> findByEnameIsStartingWith(String ename);
	  boolean existsByEemail(String eemail);

}
