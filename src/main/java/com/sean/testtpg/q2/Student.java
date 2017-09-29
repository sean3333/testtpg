package com.sean.testtpg.q2;

/**
 * 
 * @author sean
 *
 */
public class Student {
	
	// assume id is a number
	private int id;
	private String firstname;
	private float gpa;
	
	@Override
	public String toString(){
		return this.getFirstname() +"\t"+this.getId();
	}
	
	public Student(){
		this.id =0;
		this.firstname ="";
		this.gpa = 0.0f;
	}
	
	public Student(int id, String firstname, float gpa){
		this.id = id;
		this.firstname = firstname;
		this.gpa = gpa;
	}	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public float getGpa() {
		return gpa;
	}
	public void setGpa(float gpa) {
		this.gpa = gpa;
	}
	

}
