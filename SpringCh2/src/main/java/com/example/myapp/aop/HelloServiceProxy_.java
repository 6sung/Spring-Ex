package com.example.myapp.aop;

public class HelloServiceProxy_ extends HelloService{
	
	public String sayHello(String name) {
		//HelloLog.log();
		return super.sayHello(name);
	}
}
