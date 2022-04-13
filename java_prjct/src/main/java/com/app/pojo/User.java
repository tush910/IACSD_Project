package com.app.pojo;

import java.util.List;

import javax.persistence.*;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "users")
public class User {
     
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
     
    @Column(nullable = false, unique = true, length = 45)
    private String email;
     
    @Column(nullable = false, length = 64)
    private String password;
     
 

	@Column(name = "first_name", nullable = false, length = 20)
    private String firstName;
     
    @Column(name = "last_name", length = 20)
    private String lastName;
    
    @Column(name = "address", length = 20)
    private String address;
    
    @Column(name = "city", length = 20)
    private String city;
    
    @Column(name = "mobile", length = 20)
    private String mobile;
    
    @OneToMany(mappedBy="User")
	private List<Plant> plants;
    
    @OneToMany(mappedBy="User")
 	private List<Plant> netmetering;



}
