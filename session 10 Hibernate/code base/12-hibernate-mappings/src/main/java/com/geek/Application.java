package com.geek;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.geek.entity.Department;
import com.geek.entity.Designation;
import com.geek.entity.Employee;
import com.geek.repository.DepartmentRepo;

@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		ApplicationContext ctx=
		SpringApplication.run(Application.class, args);
	DepartmentRepo repo=ctx.getBean(DepartmentRepo.class);
	/*
	 * Department d= new Department(); d.setDeptId(992); d.setDeptName("Accounts");
	 * repo.addDepartment(d);
	 */
	/*
	 * Employee e=new Employee(); e.setEmpId(104); e.setEmpName("Sanjay");
	 * e.setDesignation(Designation.Manager); repo.addEmployee(e, 992);
	 */
	//repo.updateEmpDesignation(104, Designation.Manager);
	repo.readDepartment(991);
	}

}
