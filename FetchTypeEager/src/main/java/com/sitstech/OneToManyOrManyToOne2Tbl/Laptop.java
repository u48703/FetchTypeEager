package com.sitstech.OneToManyOrManyToOne2Tbl;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="laptop_Many_To_One_2Tbls")
public class Laptop {
	@Id
	private int lId;
	private String lName;
	@ManyToOne // indicate that its may to one and relationship should be indicate in the laptop_Many_To_One_2Tbls table
	private Student student;// in to string method we removed the  student to avoid stackoverflow exeption
	public int getlId() {
		return lId;
	}
	public void setlId(int lId) {
		this.lId = lId;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	@Override
	public String toString() {
		return "Laptop [lId=" + lId + ", lName=" + lName + "]";
	}
	
	

}
