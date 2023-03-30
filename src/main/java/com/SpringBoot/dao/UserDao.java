package com.SpringBoot.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SpringBoot.model.User;


@Transactional
@Repository
public interface UserDao extends JpaRepository<User, Integer> {
	
	boolean existsByEmailAndPassword(String email,String password);
	
	List<User> findByEmail(String email);
	
	List<User> findAll();	
	
	void deleteById(int id);
}
