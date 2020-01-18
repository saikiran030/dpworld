package com.problem.four;
import java.util.*;
class EmployeeHistory{
	private LinkedList<Employee> eh;
	public EmployeeHistory(LinkedList<Employee> eh) {
		this.eh = eh;
	}
	public LinkedList<Employee> getEh() {
		return eh;
	}
}

class Employee{
	private String employeeName;
	private LinkedList<Designation> dh;
	public Employee(String employeeName, LinkedList<Designation> dh) {
		this.employeeName = employeeName;
		this.dh = dh;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public LinkedList<Designation> getDh() {
		return dh;
	}
}

class Designation{
	private String Designation;
	private String Year;

	public Designation(String designation, String year) {
		Designation = designation;
		Year = year;
	}
	
	public String getDesignation() {
		return Designation;
	}
	public String getYear() {
		return Year;
	}
	
}

public class HelloWorld {
	public static void main(String args[]){
		Designation ds1 = new Designation("SDE1","2018");
		Designation ds2 = new Designation("SDE2","2019");
		LinkedList<Designation> dh= new LinkedList();
		dh.add(ds1);
		dh.add(ds2);
		Employee ee = new Employee("Sai",dh);
		LinkedList<Employee> ed= new LinkedList();
		ed.add(ee);
		EmployeeHistory eh = new EmployeeHistory(ed);
		getEmployeeHistory(eh);
	}

	static void getEmployeeHistory(EmployeeHistory eh) {
		// TODO Auto-generated method stub
		System.out.println(eh.getEh().get(0).getEmployeeName());
		System.out.println(eh.getEh().get(0).getDh().get(0).getDesignation());
		System.out.println(eh.getEh().get(0).getDh().get(1).getDesignation());
	}
}
