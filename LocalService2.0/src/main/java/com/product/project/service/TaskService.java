package com.product.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.product.project.model.Task;
import com.product.project.repository.Repository;

@Service
public class TaskService {
	@Autowired
	public Repository trepo;
	
	//post data
	public String postData(Task t)
	{
		trepo.save(t);
		return "Your data is saved successfully";
	}
	//get data
	public List<Task> getData()
	{
		return trepo.findAll();
	}

	//get all data
	public List<Task> getAllRows()
	{
		return trepo.getAllRows();
	}
	//get by Char
	public List<Task> getDataByChar(String name)
	{
		return trepo.getByname(name);
	}
	//delete the data
	public int deleteById(int id)
	{
		return trepo.deleteId(id);
	}
	public Task getUserData(int id) {
	return trepo.getUserData(id);
	}
	public List<Task> sortByAsc(String name)
	{
		return trepo.findAll(Sort.by(name).ascending());
	}
	public List<Task> sortByDsc(String name)
	{
		return trepo.findAll(Sort.by(name).descending());
	}

	//pagination
	public List<Task> pagination(int pageNu,int pageSize)
	{
		Page<Task> cont= trepo.findAll(PageRequest.of(pageNu, pageSize));
		return cont.getContent();
	}
	//sorting
	public List<Task> paginationAndSorting(int pagNu,int pageSize,String name)
	{
		Page<Task> cont1=trepo.findAll(PageRequest.of(pagNu, pageSize,Sort.by(name)));
		return cont1.getContent();
	}
}