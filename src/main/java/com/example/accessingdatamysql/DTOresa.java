package com.example.accessingdatamysql;


public class DTOresa {

private String day;
private Integer hour;
private Integer guest;
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
	
public Reservation dtoToDao() {
	Reservation res = new Reservation();
	res.setHour(this.hour);
	res.setDay(this.day);
	res.setGuest(this.guest);
	res.setName(this.name);
	return res;
	}

}


