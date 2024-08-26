package com.geek.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.geek.entity.BookUser;

public interface BookUserRepository extends JpaRepository<BookUser, Integer>{

}
