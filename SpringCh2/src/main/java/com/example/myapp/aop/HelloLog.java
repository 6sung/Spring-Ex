package com.example.myapp.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
public class HelloLog {
	
	@Pointcut(value="execution(* com.example..*.sayHello(..))")
	private void helloPointcut() {}
	
	@After("helloPointcut()")
	public static void log(JoinPoint joinPoint) {
		Signature signature = joinPoint.getSignature();
		String methodName = signature.toLongString();
		System.out.println("111>>>LOG<<< : method name - " + methodName); 
		System.out.println(">>>LOG<<< : " + new java.util.Date());
	}
	
	@AfterReturning(value="helloPointcut()", returning = "resultObj")
	public void resultLog(JoinPoint joinPoint, Object resultObj) {
		Signature signature = joinPoint.getSignature();
		String methodName = signature.toLongString();
		System.out.println("222>>>LOG<<< : method name - " + methodName); 
		System.out.println("code return result : " + resultObj.toString());
	}
	//@Before("helloPointcut()")
	
	
	
	@AfterThrowing(value="helloPointcut()", throwing="exception")
	public void exceptionLog(JoinPoint joinPoint, Exception exception) {
		Signature signature = joinPoint.getSignature();
		String methodName = signature.toLongString();
		System.out.println(">>>EXCEPTION KOG<<< : " + methodName);
		System.out.println("EEXXCCEEPPTTIIOONN message - " + exception.getMessage());
	}
	
	@Around("helloPointcut()")
	public Object aroundLog(ProceedingJoinPoint joinPoint) {
		//ProceedingJoinPoint is a JoinPoint
		Object result = null;
		Signature signature = joinPoint.getSignature();
		String methodName = signature.getName();
		System.out.println(">>>>BEFORE LOG<<<< : method name ---- " + methodName);
		try {
			result = joinPoint.proceed(); //핵심코드가 실행
		}catch(Throwable e) {
			System.out.println(">>>>>>>>>>>>>>>>>>EXCEPTION LOG<<<<<<<<<<<<<<<<<<<<< : message - " + e.getMessage());
		}finally {
			System.out.println(">>>FINALLY<<<");
		}
		return result;
	}
}
