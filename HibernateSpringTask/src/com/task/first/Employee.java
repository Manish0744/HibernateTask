package com.task.first;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

@Entity  
@Table(name="Employee101") 
public class Employee {

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)  
    private long empId; 
	private String empName; 
	
	@OneToMany(cascade = CascadeType.ALL)  
	@JoinColumn(name="empId")  
	@OrderColumn(name="type")  
	private List<Address> addresses;
	
	@ManyToOne(cascade=CascadeType.ALL)  
	private Department department;  
	
	private Date dateOFBirth;
	private Date joiningDate;
	public long getEmpId() {
		return empId;
	}
	public void setEmpId(long empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public List<Address> getAddresses() {
		return addresses;
	}
	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public Date getDateOFBirth() {
		return dateOFBirth;
	}
	public void setDateOFBirth(Date dateOFBirth) {
		this.dateOFBirth = dateOFBirth;
	}
	public Date getJoiningDate() {
		return joiningDate;
	}
	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", addresses=" + addresses + ", department="
				+ department + ", dateOFBirth=" + dateOFBirth + ", joiningDate=" + joiningDate + "]";
	}
}
