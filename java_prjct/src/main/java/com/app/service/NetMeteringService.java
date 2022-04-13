package com.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.pojo.NetMetering;
import com.app.pojo.Plant;
import com.app.repository.NetMeteringRepository;

import com.app.repository.UserRepository;

@Service
public class NetMeteringService {

	@Autowired
	NetMeteringRepository netRepo;
	
	@Autowired
	UserRepository usRepo;
	
	public void save(NetMetering net) {
		netRepo.save(net);
	}
	
	public void saveById(Long netId) {
		netRepo.save(netRepo.findById(netId).get());
	}
	
	public List<NetMetering> findAll(){
		return (List<NetMetering>) netRepo.findAll();
	}
	

	public NetMetering findById(long netId) {
		NetMetering net = netRepo.findById(netId).get();
		return net;
	}
	
	
	
	public List<NetMetering> getByKW(String KW){
		List<NetMetering> nets = new ArrayList<>();
		for (NetMetering net : netRepo.findAll()) {
			if (net.getKW().equals(KW)) {
				nets.add(net);
			}
		}
		return nets;
	}
	
public List<NetMetering> searchNetMetering(String KW){
		
		List<NetMetering> searchedNetMetering = new ArrayList<NetMetering>();
		
		if (KW != null ) {
			searchedNetMetering = getByKW(KW);
		}
		
		return searchedNetMetering;
	}




	
	
}

