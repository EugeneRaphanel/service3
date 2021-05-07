package com.example.accessingdatamysql;

import javax.persistence.Entity;
import javax.persistence.IdClass;
import javax.persistence.Id;
import org.springframework.validation.annotation.Validated;
import org.springframework.boot.context.properties.ConfigurationProperties;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import java.lang.String;

@ConfigurationProperties
@Validated
@Entity
class Reservation{

@Id
@GeneratedValue(strategy=GenerationType.AUTO)	
private Integer id;

@NotEmpty
private String day;


@Min(value = 11, message = "to early restaurant not open")
@Max(value = 23, message = "to late we're closed")
private Integer hour;

@Min(value = 1, message = "need at least 1 person")
@Max(value = 23, message = "table too big")
private Integer guest;

@NotEmpty
private String name;

public Integer getHour() {
		return hour;
	}

public void setHour(Integer hour) {
		this.hour = hour;
	} 
	
public Integer getGuest() {
		return guest;
	}

public void setGuest(Integer guest) {
		this.guest = guest;
	} 
	
public String getDay() {
		return day;
	}

public void setDay(String day) {
		this.day = day;
	}

public String getName() {
		return name;
	}

public void setName(String name) {
		this.name = name;
	}
	
public boolean checkDay(){
	 String[] days = new String[]{ "monday","tuesday","wednesday","thursday","friday","saturday","sunday"}; 
	 boolean ret = false;
	 for( int i =0; i <days.length; i++){
		ret = ret || day.equalsIgnoreCase(days[i]);
		} 
	return ret;
	}
public String toString() {

	return "{ id : "+ id + ", day : "+ day + ", hour : "+ hour + " , guest : " + guest +", name : "+ name + " }";
	}
	
public DTOresa daoToDto() {
	DTOresa res = new DTOresa();
	res.setHour(this.hour);
	res.setDay(this.day);
	res.setGuest(this.guest);
	res.setName(this.name);
	return res;
	}
}



