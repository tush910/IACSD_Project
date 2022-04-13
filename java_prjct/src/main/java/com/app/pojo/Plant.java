package com.app.pojo;

import java.time.LocalDate; 
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="PLANTS")
public class Plant {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long PlantId;
    
	@Column(name="KW")
	private String KW;
	
	@Column(name="Area")
	private int Area;
	
	@Column(name="No_of_Panels")
	private int panel;
	
	@Column(name="Rs_per_watt")
	private String RsPerWatt;
	
	@Column(name="Cost_of_Panels")
	private double Cost_panels;
	
	@Column(name="Cost_of_Inverter")
	private double Cost_Inverter;
	
	@Column(name="Cost_Others")
	private double Cost_Others;
	
	@Column(name="Total_Cost_of_Plant")
	private double Cost_Total;
	

	

	
	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH},
			fetch = FetchType.LAZY)
	private User User;
	
	public Plant() {
		
	}

	public Plant(long plantId, String kW, int area, int panel, String rsPerWatt, double cost_panels, double cost_Inverter,
			double cost_Others, double cost_Total, User theUser) {
		super();
		PlantId = plantId;
		KW = kW;
		Area = area;
		this.panel = panel;
		RsPerWatt = rsPerWatt;
		Cost_panels = cost_panels;
		Cost_Inverter = cost_Inverter;
		Cost_Others = cost_Others;
		Cost_Total = cost_Total;
		this.User = theUser;
	}



	
	
}
