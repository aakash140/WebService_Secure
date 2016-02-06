package com.java.ws.secure;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface CalculatorIfc {

	public void add(int num1,int num2);

	public void sub(int num1,int num2);

	public void div(int num1,int num2);

	public void multiply(int num1,int num2);

	@WebMethod(exclude=true)	
	public boolean isAuthentic();
}