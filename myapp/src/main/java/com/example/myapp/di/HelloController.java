package com.example.myapp.di;

public class HelloController {
	IHelloService helloService;
	
	public void setHelloService(IHelloService helloService) {
		this.helloService = helloService;
	}
	
//	public HelloController(IHelloService helloService) {
//		this.helloService = helloService;
//	}
	
	public void hello(String name) {
		System.out.println(helloService.sayHello(name));
	}
}
