package com.app.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.app.pojo.Plant;
import com.app.pojo.User;
 
public interface UserRepository extends JpaRepository<User, Long> {

	 @Query("SELECT u FROM User u WHERE u.email = ?1")
	    public User findByEmail(String email);

	
	 
//	 @Query("SELECT user FROM User user WHERE user.id=?1")
//	  public  User findById(long id);

//	public List<User> findById();
	 
//	 @Query("SELECT u FROM User u WHERE u.id = ?1")
//	 public Optional<User>  findById(Long id);
	 

//	public User findById();
}