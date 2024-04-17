package com.example.myapp.aop;

public class HelloController {
	IHelloService service;
	
	public void setService(IHelloService service) {
		this.service = service;
	}
	
	public void hello(String name) {
		String result = service.sayHello(name);
		System.out.println(result);
	}
}
