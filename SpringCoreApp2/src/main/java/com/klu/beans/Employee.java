package com.klu.beans;

public class Employee {
private int eid;
private String ename;
private String desig;
private double sal;
private Department dept;
public Employee(int eid, String ename, String design, double sal, Department dept) {
	super();
	this.eid = eid;
	this.ename = ename;
	this.desig = desig;
	this.sal = sal;
	this.dept = dept;
}
public void getEmpdetails() {
	System.out.println("Emp ID: " +eid);
	System.out.println("Emp Name: " +ename);
	System.out.println("Emp designation :" +desig);
	System.out.println("Emp salary: " +sal);
	dept.getDeptDetails();
	
}
}
