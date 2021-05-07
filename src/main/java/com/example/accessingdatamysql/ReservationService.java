package com.example.accessingdatamysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.lang.String;
@Service
@Transactional
public class ReservationService {
	private static final Logger log = LoggerFactory.getLogger(AccessingDataMysqlApplication.class);
	
	@Autowired
	private ReservationRepository resarep;
  
  public DTOresa saveResa(DTOresa u){
		DTOresa response = new DTOresa();
		Reservation r = u.dtoToDao();
		//log.info(Boolean.toString(!checkDayandHour(r)));
		if(!r.checkDay() ||  !checkDayandHour(r)) {
			response.setDay("error wrong argument");
 			return response;
		}
		try {
			resarep.save(r);
		}
		catch (Exception IllegalArgumentException){
			response.setDay("error saving the reservation");
 			return response;
		}
		log.info(r.toString());
		response.setDay("ok");
 		return response;
	}
	
	private Iterable<Reservation> findAllResa(){
		return resarep.findAll();
		
	}
  	
  	private List<DTOresa> iterabletoDTOresa(Iterable<Reservation> iterable) {
		Iterator<Reservation> it = iterable.iterator();
		List<DTOresa> result = new ArrayList<DTOresa>();
		DTOresa u ;
    		while(it.hasNext()){
    			u = it.next().daoToDto();
    			result.add(u);
    		}
    		return result;
	}
  	
  	public List<DTOresa> returnAllresa(){
		Iterable<Reservation> iterable = this.findAllResa();
		return iterabletoDTOresa(iterable);
		}
  	
  	private List<Reservation> iterabletoList(Iterable<Reservation> iterable) {
		Iterator<Reservation> it = iterable.iterator();
		List<Reservation> result = new ArrayList<Reservation>();
		Reservation u ;
    		while(it.hasNext()){
    			u = it.next();
    			result.add(u);
    		}
    		return result;
	}
  	
  	private boolean checkDayandHour(Reservation r) {
  		List<Reservation>  resa = iterabletoList(findAllResa());
  		log.info(r.getDay()+", "+r.getHour());
  	 	for (Reservation i : resa) {
  	 		//log.info(i.getDay()+", "+i.getHour());
      			if (i.getDay().equalsIgnoreCase(r.getDay()) && i.getHour() == r.getHour() ){
      				log.info("i return false");
      				return false;
      			}
    		}
    		return true;
  	}
  	
  	private List<Reservation> findByNameIgnoreCase(String name){
		return resarep.findByNameIgnoreCase(name);
	}
	
	private List<Reservation> findByDayAndHour(String day, Integer hour){
		return resarep.findByDayAndHour(day,hour);
	}
	
	public List<DTOresa> returnResaByName(String name){
		Iterable<Reservation> iterable = this.findByNameIgnoreCase(name);
		return iterabletoDTOresa(iterable);
		}
	
	
	public List<DTOresa> returnResaByDayAndHour(String name, Integer hour){
		Iterable<Reservation> iterable = this.findByDayAndHour(name,hour);
		return iterabletoDTOresa(iterable);
		}
		
	public DTOresa deleteResaBydayAndHour(String day, Integer hour) {
		DTOresa response = new DTOresa();
 		//try{
 		resarep.deleteByDayAndHour(day, hour);
 		//resarep.deleteById(hour);
 		//}
 		/*catch( Exception ResourceNotFoundException){
 			response.setDay("not deleted");
 			return response;
 		}*/
 		response.setDay("ok");
 		return response;
	
	}
	}

