package com.product.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.product.project.model.Task;

import jakarta.transaction.Transactional;
@org.springframework.stereotype.Repository
public interface Repository extends JpaRepository<Task, Integer>{
	//native Query
	@Query(value = "select * from _product",nativeQuery = true)
	public List<Task> getAllRows();
	//get by char
	@Query (value = "select * from _product where name like %?1%",nativeQuery = true)
	public List<Task> getByname(@Param("name") String name);
	//delete using native query
	@Modifying
	@Transactional
	@Query(value = "delete from _product where id=:no_id",nativeQuery = true)
	public int deleteId(@Param("no_id") int id);
//	@Modifying
//	@Transactional
	@Query(value="select * from _product join _order.id = _product._order.id where _order.id = ?1",nativeQuery=true)
	Task getUserData(int id);
}

