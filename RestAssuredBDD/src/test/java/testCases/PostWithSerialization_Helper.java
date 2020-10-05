package testCases;

import java.util.List;

public class PostWithSerialization_Helper {
	
	public String name;
	public String job;
	public List<String> courses;
	
	public void setname(String name) {
		this.name=name;
	}
	
	public String getname() {
		return name;
	}
	
	public void setjob(String job) {
		this.job=job;
	}
	
	public String getjob() {
		return job;
	}
	
	public void setCourses(List courses) {
		this.courses=courses;
	}
	
	public List<String> getCourses() {
		return courses;
	}
	
	
	
}
