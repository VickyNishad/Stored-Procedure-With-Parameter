package com.test.dao;

import java.util.List;
import java.util.stream.Stream;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.entities.Student;

@Repository
public class StudentDao {
	
	@Autowired
	private  EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	public List<Student> getList() {
		return entityManager.createNamedStoredProcedureQuery("getall").getResultList();
	}
	
	public Object getStudentNameAndEmail(String id)
	{
		return entityManager.createNamedStoredProcedureQuery("getById").setParameter("id", id).getSingleResult();
	}
	
	@SuppressWarnings("rawtypes")
	public Stream getStudent(long id)
	{
		return entityManager.createNamedStoredProcedureQuery("getById").setParameter("id", id).getResultStream();
	}

}
