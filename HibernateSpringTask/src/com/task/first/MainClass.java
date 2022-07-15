package com.task.first;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class MainClass {

	public static void main(String[] args) throws ParseException {
	    StandardServiceRegistry ssr=new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
	    Metadata meta=new MetadataSources(ssr).getMetadataBuilder().build();  
	      
	    SessionFactory factory=meta.getSessionFactoryBuilder().build();  
	    Session session=factory.openSession();  
	      
	    Transaction t= session.beginTransaction();
	    
	    //Address1
	    Address address1 = new Address();
	    address1.setPinCode("324009");
	    address1.setStreetName("Dadabari");
	    address1.setCity("Kota");
	    address1.setAddressType(AddressType.Permenant);
	    
	    Address address2 = new Address();
	    address2.setPinCode("546006");
	    address2.setStreetName("BTM");
	    address2.setCity("Bangalore");
	    address2.setAddressType(AddressType.Present);
	    
	    ArrayList<Address> addressList =new ArrayList<Address>();    
	    addressList.add(address1); addressList.add(address2);
	    
	   	    
	    //Address2
	    Address address3 = new Address();
	    address3.setPinCode("858563");
	    address3.setStreetName("Ranpur");
	    address3.setCity("Kota");
	    address3.setAddressType(AddressType.Permenant);
	    
	    Address address4 = new Address();
	    address4.setPinCode("747485");
	    address4.setStreetName("Whitefield");
	    address4.setCity("Bangalore");
	    address4.setAddressType(AddressType.Present);
	    
	    ArrayList<Address> addressList2 =new ArrayList<Address>();    
	    addressList2.add(address3); addressList2.add(address4);
	    
	    
	    //Department
	    Department dept = new Department();
	    dept.setDeptName("IT");
	    
	    //Employee1
	    Employee emp1 = new Employee();
	    emp1.setEmpName("Manish Gupta");
	    SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("MM/dd/yyyy");
	    emp1.setDateOFBirth(simpleDateFormat1.parse("08/26/1995"));
	    emp1.setJoiningDate(simpleDateFormat1.parse("06/20/2022"));
	    emp1.setAddresses(addressList);
	    emp1.setDepartment(dept);
	    
	    //Employee2
	    Employee emp2 = new Employee();
	    emp2.setEmpName("Rajesh Nagar");	   
	    SimpleDateFormat simpleDateFormat3 = new SimpleDateFormat("MM/dd/yyyy");	    
	    emp2.setDateOFBirth(simpleDateFormat3.parse("05/16/1993"));
	    emp2.setJoiningDate(simpleDateFormat3.parse("06/01/2002"));
	    emp2.setAddresses(addressList2);
	    emp2.setDepartment(dept);
	    
	    ArrayList<Employee> empList =new ArrayList<Employee>();    
	    empList.add(emp1);
	    empList.add(emp2);
	    dept.setEmployees(empList);
	    
	    //-------------------------------Fetch Address By Using Named Query-------------------------------
//	    Query<Address> query = session.getNamedQuery("address");
//	    Address address = (Address)query.uniqueResult();
//	    System.out.println("Address is : " + address);
   	    
	    
	    //-------------------------------CURD for Employee and Department-------------------------------
	    
	   //Fetch Employee data
//	    Criteria cit = session.createCriteria(Employee.class);
//	    List<Employee> listEmp = cit.list();
//	    for(Employee emp : listEmp)
//	    	System.out.println("Employee Data is : " + emp.getEmpId() + " " + emp.getEmpName() + " " + emp.getAddresses());
	    
	    
	  //Fetch Department data
//	    Criteria cit2 = session.createCriteria(Department.class);
//	    List<Department> listEmp2 = cit2.list();
//	    for(Department deptt : listEmp2) {
//	    	System.out.println("Department Data is : " + deptt.getDeptId() + " " + deptt.getDeptName() + " ");
//	    	List<Employee> listEmpp = deptt.getEmployees();    	
//	    	listEmpp.stream().map(e1 -> "Department wise Employee Data is : " + e1.getEmpId() + " " + e1.getEmpName() + " " + e1.getAddresses()).forEach(System.out::println);
//	    }
	    
	    
	    //Update Employee Data
//	    Employee e1 = session.load(Employee.class, 1l);
//	    e1.setEmpName("Ravi Nagar");
//	    session.update(e1);
	    
	    
	    //Update Department Data
//	    Department d1 = session.load(Department.class, 1l);
//	    d1.setDeptName("HR");
//	    session.update(d1);
	    
	    //Delete Employee Data
//	    Employee e1 = session.load(Employee.class, 1l);
//	    session.delete(e1);
	    
	    //Delete Department Data
//	    Department d1 = session.load(Department.class, 1l);
//	    session.delete(d1);
	    
	    
	    //-------------------------------Fetch Address By Using Named Query (With Join)-------------------------------
	//    Query<List<Object[]>> query2 = session.getNamedQuery("address2");
//	    List<List<Object[]>> address2Address = query2.list();
//	    System.out.println("Address is : " + address2Address);

	  
	  session.persist(dept);     
	    t.commit();    
	    session.close();    
	    System.out.println("success");    

	}
}
