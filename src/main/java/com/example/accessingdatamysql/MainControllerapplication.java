package com.example.accessingdatamysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestBody;


import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;
import java.util.HashMap;
import java.util.Map;
import java.util.List;


@Controller	// This means that this class is a Controller
@RequestMapping(path="/demo") // This means URL's start with /demo (after Application path)
public class MainControllerapplication extends MainController {
	@Autowired
private ReservationService resaservice;

@PostMapping("/Resa")
	public @ResponseBody DTOresa createUser(@RequestBody DTOresa u) {
		return resaservice.saveResa(u); 		
 		
	}
@GetMapping("/Resa")
	public @ResponseBody List<DTOresa> getAllResa(){
		return resaservice.returnAllresa();
	}
	
@GetMapping("/Resa/{name}")
	public  @ResponseBody List<DTOresa> getResaUser(@PathVariable String name){
		return resaservice.returnResaByName(name);
	}

@GetMapping("/Resa/time/{day}/{hour}")
	public @ResponseBody List<DTOresa> getResaParam(@PathVariable String day, @PathVariable Integer hour){
		return resaservice.returnResaByDayAndHour(day,hour);
	}

	
@DeleteMapping("Resa/{day}/{hour}")
	public  @ResponseBody DTOresa deleteResa(@PathVariable String day, @PathVariable Integer hour){
		return resaservice.deleteResaBydayAndHour(day,hour);
	}	

}
