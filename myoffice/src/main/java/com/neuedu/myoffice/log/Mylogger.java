package com.neuedu.myoffice.log;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Mylogger {
	@Pointcut("execution(* com.neuedu.myoffice.service.impl.*.insert(..))"+"||"+
			"execution(* com.neuedu.myoffice.service.impl.*.update(..))")
	private void pt1() {
		
	}
	
	@Before("pt1()")
	public void beforePrint() {
		System.out.println("前置通知beforePrint方法开始记录日志...");
	}
	
	@AfterReturning("pt1()")
	public void afterReturningPrint() {
		System.out.println("后置通知afterReturningPrint方法开始记录日志...");
	}
	
	@AfterThrowing("pt1()")
	public void afterThrowingPrint() {
		System.out.println("异常通知afterThrowingPrint方法开始记录日志...");
	}
	
	@After("pt1()")
	public void afterPrint() {
		System.out.println("最终通知afterPrint方法开始记录日志...");
	}
	
	@Around("pt1()")
	public Object aroundPrint(ProceedingJoinPoint pjp) {
		Object rtObject = null;
		try {
			Object[] args = pjp.getArgs();
			System.out.println("aroundPrint方法开始记录日志了。。。前置");
			rtObject = pjp.proceed(args);
			System.out.println("aroundPrint方法开始记录日志了。。。后置");
			return rtObject;
			
		} catch (Throwable t) {
			System.out.println("aroundPrint方法开始记录日志了。。。异常");
			throw new RuntimeException(t);
		}finally {
			System.out.println("aroundPrint方法开始记录日志了。。。最终");
		}
	}
}


