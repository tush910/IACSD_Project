package com.app.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.app.pojo.NetMetering;
import com.app.pojo.Plant;
import com.app.pojo.User;
 
public interface NetMeteringRepository extends JpaRepository<NetMetering, Long> {



}