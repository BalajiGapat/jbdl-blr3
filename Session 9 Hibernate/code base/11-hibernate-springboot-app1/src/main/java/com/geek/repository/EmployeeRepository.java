package com.geek.repository;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.geek.entity.Customer;
import com.geek.entity.Employee;
import com.geek.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

@Component
@Transactional
public class EmployeeRepository {
	@PersistenceContext
private EntityManager em;
	
	
	@Transactional
public void addNewEmp(Employee e) {
	em.persist(e);
	e.setEmpName("Ganesh J");
	//debit
	//credit
	System.out.println("New Emp added");
}
	@Transactional
	public Employee searchById(int empId) {
	Employee e=	em.find(Employee.class, empId);
	em.clear();
	Employee e2=em.find(Employee.class, empId);
		if(e!=null) {
			return e;
		}
		else
			throw new RuntimeException("Employee not found");
	}
	@Transactional
	public void updateEmpEmail(int id,String email) {
		//in managed state
		Employee e=	em.find(Employee.class, id);
		if(e!=null) {
			e.setEmail(email);
			System.out.println("Email updated...");
		}
		else
			throw new RuntimeException("Employee not found");
	}
	
	public void allEmps(){
		String jpql="select e from Employee e";
		TypedQuery<Employee> emps=  em.createQuery(jpql, Employee.class);
		List<Employee>  empList=emps.getResultList();
		for(Employee e:empList) {
			System.out.println(e.getEmpName()+" "+e.getEmail()+" "+e.getEmpId());
		}
	}
	
	public void addCustomer(Customer c) {
		// TODO Auto-generated method stub
		em.persist(c);
		System.out.println("Customer added");
	}
	
	public void addStudent(Student s) {
		em.persist(s);
		System.out.println("Student added");
	}
}
