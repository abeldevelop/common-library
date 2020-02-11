package com.abeldevelop.architecture.library.common.aspect;

import java.util.StringJoiner;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
@Component
public class ControllerDataInLogAspect {

	@Around("execution(public * *..*Controller.execute*(..)) && !@annotation(com.abeldevelop.architecture.library.common.annotation.DisableDataInLog)")
	public Object logDataIn(ProceedingJoinPoint joinPoint) throws Throwable {
		StringJoiner joiner = new StringJoiner(", ");
		for(Object arg : joinPoint.getArgs()) {
			if(arg != null) {
				joiner.add(arg.toString());
			} else {
				joiner.add("null");
			}
		}
		if(log.isInfoEnabled()) {
			log.info("Data IN => " + joinPoint.getTarget().getClass() + "." + joinPoint.getSignature().getName() + " => " + joiner.toString());
		}
		return joinPoint.proceed();
	}
}
