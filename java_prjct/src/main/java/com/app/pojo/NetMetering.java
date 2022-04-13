package com.app.pojo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "netmetering")
public class NetMetering {

	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    public Long netid;
	     
	    @Column(name="month")
	    private String month;
	    
	    @Column(name="monthly_energy_consumption")
	    private double monthly_load;
	    
	    @Column(name="monthly_bill")
	    private double monthly_bill;
	    

	    @Column(name="generation")
	    private double generation;
	
	    
	    @Column(name="net_consumption_after_plant_installation")
	    private double net_power;
	    
	    @Column(name="bill_after_plant_installation")
	    private double net_bill;
	    
	    @Column(name="savings")
	    private double saving;
	    
	    @Column(name="payback")
	    private String payback;
	    
	    @Column(name="KW")
	    private String KW;
	    


}
