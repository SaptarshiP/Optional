package com.psja;

import java.util.Optional;
import java.util.function.Supplier;

public class CheckOptionalElseExceptional {

	public static void main( String args[] ) {

		
		EmployeeT empT = Optional.of( getEmployeeTData("PSJA_TEST2") ).orElseThrow(()->{
			return new CustomException(new Exception("TEST_EXCEPTION"), "PSJA_EXCEPTION_CODE", 
											"PSJA_EXCEPTION_MESSAGE");
		});
		System.out.println(empT);
	}
	
	public static EmployeeT getEmployeeTData(String employeeName) {
		if ( employeeName.equalsIgnoreCase("PSJA_TEST1") ) {
			return new EmployeeT("PSJA_001", "PSAJA_NAME");
		}else {
			return null;
		}
	}
	
}


class EmployeeT{
	private String empId;
	private String empName;
	
	public EmployeeT( String empId, String empName ) {
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

class CustomException extends RuntimeException{
	
	private String errorCode;
	private String errorMessage;
	
	public CustomException(Exception exp, String errorCode, String errorMessage) {
		super(exp);
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}
	
	public String getErrorCode() {
		return this.errorCode;
	}
	public String getErrorMessage() {
		return this.errorMessage;
	}
} 
