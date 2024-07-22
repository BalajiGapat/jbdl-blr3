package com.geek;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.geek.entity.Address;
import com.geek.entity.Customer;
import com.geek.entity.Employee;
import com.geek.entity.Student;
import com.geek.entity.StudentAddress;
import com.geek.repository.EmployeeRepository;

@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		ApplicationContext ctx=
		SpringApplication.run(Application.class, args);
		EmployeeRepository rep=ctx.getBean(EmployeeRepository.class);
		/*Employee e=new Employee();
		e.setEmpId(104);
		e.setEmpName("Ganesh");
		e.setEmail("Ganesh@geek.com");
		rep.addNewEmp(e);*/
	//	Employee e=rep.searchById(101);
		//System.out.println(e.getEmpName()+" "+e.getEmail());
		//rep.updateEmpEmail(101, "balaji@geek.in");
	  // rep.allEmps();
		/*
		Address addr=new Address();
		addr.setFlatNo("A-101");
		addr.setPlaceName("HSR layout");
		
		Customer c= new Customer();
		c.setCid(901);
		c.setCustName("Arun");
		c.setAddress(addr);
		
		rep.addCustomer(c);*/
		
		StudentAddress addr1=new StudentAddress();
		addr1.setFlatNo("A-101");
		addr1.setPlaceName("HSR layout");
		
		StudentAddress addr2=new StudentAddress();
		addr2.setFlatNo("B-991");
		addr2.setPlaceName("Koramangala");
		
		List<StudentAddress> addres= new ArrayList<>();
		addres.add(addr1);addres.add(addr2);
		
		Student s= new Student();
		s.setStudId(901);
		s.setStudName("Kamal");
		s.setAddress(addres);
		
		rep.addStudent(s);
	}
}
