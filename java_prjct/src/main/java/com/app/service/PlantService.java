package com.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.pojo.Plant;
import com.app.repository.PlantRepository;
import com.app.repository.UserRepository;

@Service
public class PlantService {

	@Autowired
	PlantRepository plantRepo;
	
	@Autowired
	UserRepository usRepo;
	
	public void save(Plant plant) {
		plantRepo.save(plant);
	}
	
	public void saveById(Long plantId) {
		plantRepo.save(plantRepo.findById(plantId).get());
	}
	
	public List<Plant> findAll(){
		return (List<Plant>) plantRepo.findAll();
	}
	

	public Plant findById(long plantId) {
		Plant plant = plantRepo.findById(plantId).get();
		return plant;
	}
	
	public List<Plant> getByKW(String KW){
		List<Plant> plants = new ArrayList<>();
		for (Plant Plant : plantRepo.findAll()) {
			if (Plant.getKW().equals(KW)) {
				plants.add(Plant);
			}
		}
		return plants;
	}
	
	public List<Plant> getByRsPerWatt(String RsPerWatt){
		List<Plant> Plants = new ArrayList<>();
		for (Plant Plant : plantRepo.findAll()) {
			if (Plant.getRsPerWatt().equals(RsPerWatt)) {
				Plants.add(Plant);
			}
		}	
		return Plants;
	}
	
	public List<Plant> getByKWAndRsPerWatt(String KW, String RsPerWatt){
		List<Plant> Plants = new ArrayList<>();
		for (Plant Plant : plantRepo.findAll()) {
			if (Plant.getKW().equals(KW) &&
				Plant.getRsPerWatt().equals(RsPerWatt)) {
				Plants.add(Plant);
			}
		}
		return Plants;
	}
	
public List<Plant> searchPlants(String KW, String RsPerWatt){
		
		List<Plant> searchedPlants = new ArrayList<Plant>();
		
		if (KW != null && RsPerWatt == null) {
			searchedPlants = getByKW(KW);
		} else if (KW == null && RsPerWatt != null) {
			searchedPlants = getByRsPerWatt(RsPerWatt);
		} else if (KW != null && RsPerWatt != null) {
			searchedPlants = getByKWAndRsPerWatt(KW, RsPerWatt);
		} 
		
		return searchedPlants;
	}


//	
//	public List<Plant> getByRsPerWatt(int RsPerWatt){
//		List<Plant> Plants = new ArrayList<>();
//		for (Plant Plant : plantRepo.findAll()) {
//			if (Plant.getRsPerWatt()==RsPerWatt) {
//				Plants.add(Plant);
//			}
//		}	
//		return Plants;
//	}
//	
//	public List<Plant> getByKWAndRsPerWatt(int KW, int RsPerWatt){
//		List<Plant> Plants = new ArrayList<>();
//		for (Plant Plant : plantRepo.findAll()) {
//			if  (Plant.getKW()==KW && Plant.getRsPerWatt()==RsPerWatt) {
//				Plants.add(Plant);
//			}
//		}
//		return Plants;
//	}
//	
//	public void deleteById(long PlantId) {
//		plantRepo.deleteById(PlantId);
//	}
	
	
}

