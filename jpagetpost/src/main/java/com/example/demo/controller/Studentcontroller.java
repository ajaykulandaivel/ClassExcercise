package com.example.demo.controller;

import java.util.List;

import org.hibernate.annotations.DialectOverride.GeneratedColumn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.StudentEntity;
import com.example.demo.service.Studentservice;

@RestController
public class Studentcontroller {
 
@Autowired
      Studentservice sser;
  @PostMapping("addstudent")
  public StudentEntity add( @RequestBody  StudentEntity ss) 
  {
	  int id=ss.getId();
	  String name=ss.getName();
	  String stream=ss.getStream();
	return sser.saveinfo(new StudentEntity(id,name,stream));
  }
  
  @GetMapping("showdetails")
  public List<StudentEntity> show(){
	  return sser.showinfo();
  }
  
  @PutMapping("update")
  public StudentEntity modify(@RequestBody StudentEntity ss) {
	return sser.changeinfo(ss);
	  
  }
  
  @DeleteMapping("delete")
  public String del(@RequestBody StudentEntity ss) {
	  return "DELETED SUCCESSFULLY";
  }
	@DeleteMapping("delid/{id}")
	public void deletemyid(@PathVariable int id) {
	   sser.deleteid(id);
	}

}
