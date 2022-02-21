package com.test.controller;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.dao.StudentDao;
import com.test.entities.Student;

@RestController
public class Controller {
	
	@Autowired
	private StudentDao studentDao;
	
	@GetMapping("/home")
	public String Home() {

		return "this is home class";
	}
	
	@GetMapping("/find")
	public List<Student> getQueryList() {
		return this.studentDao.getList();
		
	}
	
	@GetMapping("/find/{id}")
	public Object getByIdStudent(@PathVariable String id)
	{
		return this.studentDao.getStudentNameAndEmail(id);
	}

	@SuppressWarnings("rawtypes")
	@PostMapping("/find")
	public Stream getSingle(@RequestBody String student_Id)
	{
		return this.studentDao.getStudent(Long.parseLong(student_Id));
	}
}
