package com.suresh.backendserver.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Job {
	@Id
	private int jobId;
	private String jobDestination;
	private String company;
	private int salary;
	private String location;
	private String jobDesc;
	public int getJobId() {
		return jobId;
	}
	public void setJobId(int jobId) {
		this.jobId = jobId;
	}
	public String getJobDestination() {
		return jobDestination;
	}
	public void setJobDestination(String jobDestination) {
		this.jobDestination = jobDestination;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getJobDesc() {
		return jobDesc;
	}
	public void setJobDesc(String jobDesc) {
		this.jobDesc = jobDesc;
	}
	
}
