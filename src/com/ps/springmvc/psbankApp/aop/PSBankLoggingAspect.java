package com.ps.springmvc.psbankApp.aop;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PSBankLoggingAspect {
	private Logger logger = Logger.getLogger(getClass().getName());
	
	@Pointcut("execution(* com.ps.springmvc.psbankApp.controllers.*.*(..))")
	private void forControllersPackage() { }
	
	@Pointcut("execution(* com.ps.springmvc.psbankApp.services.*.*(..))")
	private void forServicesPackage() { }
	
	@Pointcut("execution(* com.ps.springmvc.psbankApp.DAO.*.*(..))")
	private void forDAOPackage() { }
	
	@Pointcut("forControllersPackage() || forServicesPackage() || forDAOPackage()")
	private void forApplication() { }
	
	@Before("forApplication()")
	public void before(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().toShortString();
		logger.info("Information: in @Before Advice: Calling the Method: " + methodName);
	}
	
	@AfterReturning(pointcut="forApplication()",returning="result")
	public void afterReturning(JoinPoint joinPoint, Object result) {
		String methodName = joinPoint.getSignature().toShortString();
		logger.info("Info: In @AfterReturning: From Method: " + methodName);
		logger.info("Info: Data Returned by Method: " + result);
	}
}
