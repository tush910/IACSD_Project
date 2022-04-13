package com.app.service;

import java.util.ArrayList; 
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.repository.*;
import com.app.pojo.User;


@Service
public class UserService {

	@Autowired
	UserRepository usRepo;
	
	public void save(User user) {
		usRepo.save(user);
	}
	
	public void saveById(Long userId) {
		User user = usRepo.findById(userId).get();
		usRepo.save(user);
	}
	
	public User findById(long id) {
		User user = usRepo.findById(id).get();
		return user;
	}
	
	public void updateUser(User user) {
		usRepo.save(user);
	}
	
	public List<User> findAll(){
		return (List<User>) usRepo.findAll();
	}
	

	
}
