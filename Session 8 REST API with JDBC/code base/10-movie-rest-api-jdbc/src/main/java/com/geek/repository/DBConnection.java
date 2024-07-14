package com.geek.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
public class DBConnection {
private Connection connection;
@Value("${mydb.driver}")
private String driverName;
@Value("${mydb.url}")
private String url;
@Value("${mydb.uname}")
private String uname;
@Value("${mydb.pwd}")
private String pwd;

public Connection getConnection() {
	return connection;
}
@PostConstruct
public void init() {
	//open the connection with the DB
	try {
		//Class.forName("com.geek.repository.Demo").newInstance();
		Class.forName(driverName);
		//estabilish connection with DB
		connection=DriverManager.getConnection(url,uname,pwd);
		System.out.println("Connected successfully with the DB");
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} catch (SQLException e) {
		e.printStackTrace();
	} 
}

@PreDestroy
public void destroy() {
	try {
		connection.close();
	} catch (SQLException e) {
		e.printStackTrace();
	}
}

}

class Demo{
	public Demo() {
		System.out.println("Demo constructor");
	}
}
