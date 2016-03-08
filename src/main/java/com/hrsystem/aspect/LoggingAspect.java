package com.hrsystem.aspect;

import org.aspectj.lang.JoinPoint;

public interface LoggingAspect {
	
	public void readRepositoryAdice(JoinPoint joinPoint);
}
