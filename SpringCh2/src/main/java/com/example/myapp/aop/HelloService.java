package com.example.myapp.aop;

public class HelloService implements IHelloService{

	@Override
	public String sayHello(String name) {
		// TODO Auto-generated method stub
		System.out.println("helloservice.sayhello() start!!!!");
		int rand = (int)(Math.random() * 10);
		if(rand<9) {
			throw new RuntimeException(">>>EERRRROORR<<<");
		}
		return "Hello~" + name;
	}

	@Override
	public String sayGoodbye(String name) {
		// TODO Auto-generated method stub
		return "Bye~" + name;
	}

}
