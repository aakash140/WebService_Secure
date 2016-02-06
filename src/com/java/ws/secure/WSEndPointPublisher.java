package com.java.ws.secure;

import javax.xml.ws.Endpoint;

public class WSEndPointPublisher {

	public static void main(String[] args) {
		Endpoint.publish("http://localhost:8085/ws_secure/calculator", new Calculator());
		System.out.println("Endpoint is successfully published!!!");
	}
}