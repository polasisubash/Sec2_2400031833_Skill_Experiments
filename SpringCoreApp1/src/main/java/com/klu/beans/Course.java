package com.klu.beans;

public class Course {
private String cid;
private String cname;
public String getcid() {
	return cid;
}
public void setcid(String cid) {
	this.cid = cid;
}
public String getcname() {
	return cname;
}
public void setcname(String cname) {
	this.cname = cname;
}
	public void displayCourseDetails() {
		System.out.println("Course ID: "  +cid);
		System.out.println("Course Name: " +cname);
	
}

}

