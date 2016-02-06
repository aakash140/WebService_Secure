package com.java.ws.secure;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.jws.WebService;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

@WebService(endpointInterface="com.java.ws.secure.CalculatorIfc")
public class Calculator implements CalculatorIfc {

	@Resource
	WebServiceContext webServiceContext;
	@Override
	public boolean isAuthentic(){
		MessageContext messageContext=webServiceContext.getMessageContext();
		Map<?,?> requestHeaders=(Map<?,?>)messageContext.get(MessageContext.HTTP_REQUEST_HEADERS);
		List<?> userNameList=(List<?>)requestHeaders.get("username");
		List<?> passwordList=(List<?>)requestHeaders.get("password");
		String userName=userNameList.get(0).toString();
		String password=passwordList.get(0).toString();
		if(userName.equalsIgnoreCase("admin"))
			if(password.equalsIgnoreCase("pass@123"))
				return true;
			else
				return false;
		else
			return false;
	}

	@Override 
	public void add(int num1, int num2) {
		// TODO Auto-generated method stub
		if(isAuthentic())
			System.out.println("The sum of "+num1+" and "+num2+" is "+(num1+num2));
		else
			System.out.println("Invalid username/password!!!!");

	}

	@Override 
	public void sub(int num1, int num2) {
		// TODO Auto-generated method stub
		if(isAuthentic())
			System.out.println(num1-num2);
		else
			System.out.println("Invalid username/password!!!!");
	}

	@Override 
	public void div(int num1, int num2) {
		// TODO Auto-generated method stub
		if(isAuthentic())
			System.out.println(num1/num2);
		else
			System.out.println("Invalid username/password!!!!");
	}

	@Override 
	public void multiply(int num1, int num2) {
		// TODO Auto-generated method stub
		if(isAuthentic())
			System.out.println(num1*num2);
		else
			System.out.println("Invalid username/password!!!!");
	}
}