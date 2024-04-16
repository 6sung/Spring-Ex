package com.example.myapp;

import org.springframework.stereotype.Service;

@Service
public class NiceService implements IHelloService{

	@Override
	public String sayHello(String name) {
		System.out.println("HelloService.niceHello()");
		return "Nice~~~~"+name;
	}

	
}
