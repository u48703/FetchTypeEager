package com.sitstech.OneToManyOrManyToOne2Tbl;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="student_One_To_Many_2Tbls")
public class Student {
	@Id
	private int rollNo;
	private String name;
	private int marks;
	//if we do not specify the fetch type then it is lazy
	@OneToMany(mappedBy="student",fetch=FetchType.EAGER)//indicates that the relation is one to many and relationship 
								//is made by the field student in the laptop_Many_To_One_2Tbls table
	private List<Laptop> laptops;//in to string method we removed the laptop to avoid stackoverflow exception
	
	public int getRollNo() {
		return rollNo;
	}
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	public List<Laptop> getLaptops() {
		return laptops;
	}
	public void setLaptops(List<Laptop> laptops) {
		this.laptops = laptops;
	}
	@Override
	public String toString() {
		return "Student [rollNo=" + rollNo + ", name=" + name + ", marks=" + marks + "]";
	}
	
	
	

}
