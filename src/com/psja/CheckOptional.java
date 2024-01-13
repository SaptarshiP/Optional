package com.psja;

import java.util.Optional;

public class CheckOptional {

	public static void main( String args[] ) {
		Employee opt = Optional.ofNullable(getEmployeeObject("PSJA2")).orElse( new Employee("DF001", "DEFAULT_EMP") );
		System.out.println(opt);
	}
	
	public static Employee getEmployeeObject( String name ) {
		
		if (name.equalsIgnoreCase("PSJA1")) {
			return new Employee( "001", "PSJA1" ); 
		}else {
			return null;
		}
	}
	
}

class Employee{
	private String empId;
	private String empName;
	
	
	public Employee( String empId, String empName ) {
		this.empId = empId;
		this.empName = empName;
	}
	
	public String getEmpId() {
		return this.empId;
	}
	public String getEmpName() {
		return this.empName;
	}

	@Override
	public String toString() {
		StringBuilder strBuilder = new StringBuilder(this.empId);
		strBuilder.append("||").append(this.empName);
		
		return strBuilder.toString();
	}
}