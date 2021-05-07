package com.example.accessingdatamysql;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public abstract class MainController {
	public abstract @ResponseBody DTOresa createUser(@RequestBody DTOresa u);
	public abstract @ResponseBody List<DTOresa> getAllResa();
	public abstract @ResponseBody List<DTOresa> getResaParam(@PathVariable String day, @PathVariable Integer hour);
	public abstract @ResponseBody List<DTOresa> getResaUser(@PathVariable String name);
	public abstract @ResponseBody DTOresa deleteResa(@PathVariable String day, @PathVariable Integer hour);
}
