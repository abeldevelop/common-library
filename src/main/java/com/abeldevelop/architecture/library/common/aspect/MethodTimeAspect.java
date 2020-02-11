package com.abeldevelop.architecture.library.common.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
@Component
public class MethodTimeAspect {

	@Around("execution(public * *..*Controller.execute*(..)) || execution(public * *..*Repository*.execute*(..))")
	public Object calculationTime(ProceedingJoinPoint joinPoint) throws Throwable {
		long start = System.currentTimeMillis();
		Object resultado = joinPoint.proceed();
		long end = System.currentTimeMillis();
		if(log.isInfoEnabled()) {
			log.info("Time spend => " + joinPoint.getTarget().getClass() + "." + joinPoint.getSignature().getName() + " => " + (end - start) + " milliseconds");
		}
		return resultado;
	}
}
