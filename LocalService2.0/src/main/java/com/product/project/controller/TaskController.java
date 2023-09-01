package com.product.project.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.product.project.model.Task;
import com.product.project.service.TaskService;


@RestController
public class TaskController {
	@Autowired
	public TaskService tserv;
	@GetMapping("/getUserData/{id}")
	public ResponseEntity<Task>getUserData(@PathVariable int id){
		return ResponseEntity.status(200).body(tserv.getUserData(id));
	}
	//posting the data
	@PostMapping("/insertingDetails")
	public String insertingDetails(@RequestBody Task t)
	{
		 tserv.postData(t);
		 return "Your data is saved successfully";
	}
	@GetMapping("/gettingDetails")
	public List<Task> gettingData(){
		return tserv.getData();
	}
	//get all row
	@GetMapping("/getAllrows")
	public List<Task> getAllRows()
	{
		return tserv.getAllRows();
	}
	//get data by char
	@GetMapping("/getByName/{char}")
	public List<Task> getByName(@PathVariable("char") String name)
	{
		return tserv.getDataByChar(name);
	}
	//delete data
	@DeleteMapping("/deleteRow/{id}")
	public String deleteRow(@PathVariable("id") int id)
	{
		return tserv.deleteById(id)+" deleted";
	}
	//sorting ascending
	@GetMapping("/sortAsc/{name}")
	public List<Task> sortasc(@PathVariable("name")String name)
	{
		  return tserv.sortByAsc(name);
	}
	//sorting descending
	@GetMapping("/sortDesc/{name}")
	public List<Task> sortdsc(@PathVariable("name")String name)
	{
		  return tserv.sortByDsc(name);
	}

	//pagination
	@GetMapping("/pagination/{num}/{size}")
	public List<Task> pagination(@PathVariable("num") int num,@PathVariable("size") int size){
		return tserv.pagination(num, size);
	}
	//pagination and sorting
	@GetMapping("/pagination/{num}/{size}/{name}")
	public List<Task> paginationAndSorting(@PathVariable("num") int num,@PathVariable("size") int size,@PathVariable("name") String name){
		return tserv.paginationAndSorting(num, size,name);
	}
	}
