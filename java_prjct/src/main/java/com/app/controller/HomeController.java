package com.app.controller;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.app.pojo.NetMetering;
import com.app.pojo.Plant;
import com.app.pojo.User;
import com.app.repository.NetMeteringRepository;
import com.app.repository.PlantRepository;
import com.app.repository.UserRepository;
import com.app.service.IUserService;
import com.app.service.NetMeteringService;
import com.app.service.PlantService;
import com.app.security.CurrentUserFinder;

@Controller
public class HomeController {
	
	
	
public HomeController() {
	
	System.out.println("in ctor of "+getClass());
}

       @Autowired
        private UserRepository userRepo;

       @Autowired
       private IUserService service;
       
       @Autowired
       private PlantService plantservice;
       
       @Autowired
       private PlantRepository plantRepo;
       
       @Autowired
   	   CurrentUserFinder currentUserFinder;
       
       @Autowired
       private NetMeteringRepository nettRepo;
       
       @Autowired
       private NetMeteringService netservice;
 
 
       @GetMapping("")
       public String viewHomePage() {
        return "index";
}
	
       @GetMapping("/register")
       public String showRegistrationForm(Model model) {
           model.addAttribute("user", new User());
           return "signup_form";
       }
       
       @PostMapping("/process_register")
       public String processRegister(User user) {
           BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
           String encodedPassword = passwordEncoder.encode(user.getPassword());
           user.setPassword(encodedPassword);
            
           userRepo.save(user);
            
           return "register_success";
       }
       
   	
       @GetMapping("users")
  	    public String userHome(Model model) {
  		User currentUser = currentUserFinder.getCurrentUser();
  		model.addAttribute("currentUser", currentUser);
  		return "users";
  	}
           
           
           

       
      
       
       @GetMapping(value="/plants")
   	public String browsePlants(@RequestParam (required=false) String KW,
   							  @RequestParam (required=false) String RsPerWatt,
   							  @RequestParam (required=false) String showAllPlants,

   							  Model model) {
   	
		
   						
   		List<Plant> plants;
   		if (showAllPlants == null) plants = plantservice.searchPlants(KW, RsPerWatt);
   		else plants = plantservice.findAll();		
   						
   		
   		model.addAttribute("KW", KW);
   		model.addAttribute("RsPerWatt", RsPerWatt);
   		model.addAttribute("showAllPlants", showAllPlants);
   		model.addAttribute("plants", plants);
   		return "plant-lists";
   	}

       @GetMapping(value="/netmetering")
      	public String browseNetMetering(@RequestParam (required=false) String KW,
      			                        @RequestParam (required=false) String showAll,
      							    	  Model model) {
      	   		
      						
      		List<NetMetering> net;
      		if (showAll == null) net = netservice.searchNetMetering(KW);
      		else net = netservice.findAll();		
      						
      		
      		model.addAttribute("KW", KW);
      		model.addAttribute("showAll", showAll);
      		model.addAttribute("net", net);
      		return "net";
      	}   
       

   	@GetMapping("/login")
   	public String loginPage() {
   		return "login";
   	}
   	


       
}
