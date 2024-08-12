package com.geek.dao;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.geek.entity.User;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
@Component
public class UserDaoImpl implements UserDao {
	@PersistenceContext
	private EntityManager em;
	@Transactional
	public User registerNewUser(User user) {
		 em.persist(user);
		 return user;
	}
	public User searchByUserName(String userName) {
	Query q=em.createQuery("select user from User user where user.userName= :n");
	q.setParameter("n", userName);
		List<User>  users=q.getResultList();
		if(users.size()>0)
		return  users.get(0);
		else return null;
	}
}
