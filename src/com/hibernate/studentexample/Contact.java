package com.hibernate.studentexample;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "STUDENT_CONTACT")
public class Contact {
	@Id
	@GeneratedValue(generator="newgen")
	@GenericGenerator(name="newgen", strategy="foreign", parameters={@Parameter(value="student", name="property")})
	private int rollNo;

	private String mobileNumber;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "rollNo")
	private Student student;

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public int getRollNo() {
		return rollNo;
	}

	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

}
