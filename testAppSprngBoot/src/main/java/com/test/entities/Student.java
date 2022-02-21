package com.test.entities;

import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;

@Entity
@Table(name = "stdTable")
@NamedStoredProcedureQueries({@NamedStoredProcedureQuery(name = "getall", procedureName = "getAll"),
	@NamedStoredProcedureQuery(name = "getById" , procedureName = "spGetDeatils",parameters = {@StoredProcedureParameter(
	mode = ParameterMode.IN, name = "id" , type = String.class )})})
public class Student {
	
	@Id
	@GeneratedValue
	@Column(name = "student_Id")
	private long id;
	
	@Column(name = "student_name")
	private String name;
	
	@Column(name = "Email_Id")
	private String email;

	public Student(long id, String name, String email) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", email=" + email + "]";
	}

}
