package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.StudentEntity;
import com.example.demo.repository.StudentRepo;

@Service
public class Studentservice {
   
	@Autowired
	StudentRepo sr;
	
	public StudentEntity saveinfo(StudentEntity ss)
	{
		return sr.save(ss);
	}
	public List<StudentEntity> savedetails(List<StudentEntity> ss){
		return (List<StudentEntity>)sr.saveAll(ss);
	}
	
	public List<StudentEntity> showinfo()
	{
		return sr.findAll();
	}
	
	public StudentEntity changeinfo(StudentEntity ss)
	{
		return sr.saveAndFlush(ss);
	}
	
	public void deleteinfo(StudentEntity ss) {
		sr.delete(ss);
		
	}
	public void deleteid(int id) {
		sr.deleteById(id);
	}
}
