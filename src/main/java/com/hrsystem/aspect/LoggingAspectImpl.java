package com.hrsystem.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspectImpl implements LoggingAspect {

	private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspectImpl.class);
	
	@Override
	@Before("execution(public com.hrsystem.*.*(..))")
	public void readRepositoryAdice(JoinPoint joinPoint) {
		LOGGER.info(joinPoint.toString() + " has been called");
		LOGGER.info("--------------------------");
		LOGGER.debug("hi");
		System.out.println("------------ aspect calls by " + joinPoint.getSignature() + " -----------------");
	}

}
