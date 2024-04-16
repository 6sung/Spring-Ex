package com.example.myapp;

import org.springframework.stereotype.Service;

@Service
public class HelloService implements IHelloService{

	@Override
	public String sayHello(String name) {
		// TODO Auto-generated method stub
		System.out.println("HelloService.sayHello()");
		String message = "Hello~~" + name;
		return message;
	}

}
