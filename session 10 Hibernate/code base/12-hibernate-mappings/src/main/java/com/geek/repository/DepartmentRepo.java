package com.geek.repository;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.geek.entity.Department;
import com.geek.entity.Designation;
import com.geek.entity.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Component
@Transactional
public class DepartmentRepo {
	@PersistenceContext
private EntityManager em;
	@Transactional
	public void addDepartment(Department d) {
		em.persist(d);
		System.out.println("Department added");
	}
	public void addEmployee(Employee e, int deptId) {
		//here in emp obj v can add
		//dept obj and persist
		Department d=em.find(Department.class,deptId);
		if(d!=null) {
			e.setDept(d);
			em.persist(e);
			System.out.println("Emp added");
		}
		else
			System.out.println("Incorrect deptId");
		
	}
	
	public void updateEmpDesignation(int eid,Designation desg) {
		Employee e= em.find(Employee.class, eid);
		if(e!=null) {
			e.setDesignation(desg);
			System.out.println("updated");
		}
		else
			System.out.println("Incorrect emp id");
	}
	
	public void readDepartment(int did) {
		//here it will read only dept NOT employees
		Department d=em.find(Department.class, did);
		if(d!=null) {
			System.out.println(d.getDeptName());
			//returns proxy object
			List<Employee>empList=  d.getEmpList();
			
			System.out.println("***************");
			for(Employee e:empList) {
				System.out.println(e.getEmpId());
				System.out.println(e.getEmpName());
			}
		}
	}
}
