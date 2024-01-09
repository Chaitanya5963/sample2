package com.demoJDBC.demo;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerDemo {
	@Autowired
	ServiceDemo sd;

	@PostMapping("/demo-cdb")
	public HashMap<Integer, String> createDB(@RequestBody Database ob){
		return sd.createDB(ob);
	}
	
	@PostMapping("/demo-ddb")
	public HashMap<Integer, String> dropDB(@RequestBody Database ob){
		return sd.dropDB(ob);
	}
	
	@PostMapping("/demo-ctab")
	public HashMap<Integer, String> createTable(@RequestBody TableData ob){
		return sd.createTable(ob);
	}
	
	@PostMapping("/demo-i")
	public HashMap<Integer, String> insertData(@RequestBody InsertData ob){
		return sd.insertData(ob);
	}
	
	@PostMapping("/demo")
	public HashMap<String, String> fun(@RequestBody demo ob){
		return sd.fun(ob);
	}
	
}