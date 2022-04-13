package com.app.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.pojo.User;
import com.app.repository.UserRepository;


@Service
@Transactional
public class IUserService {
 
	
    @Autowired 
    public UserRepository user;
	
	 public User get(long id) {
	        return user.findById(id).get();
	    }
}
