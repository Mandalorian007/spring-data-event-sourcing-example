package com.mcf7.eventsourcing.test.data.logging;

import com.mcf7.eventsourcing.test.data.events.MyEventValidator;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyEventValidatorLoggingAspect {
    public static Logger log = LoggerFactory.getLogger(MyEventValidator.class);

    @Pointcut("execution(* com.mcf7.eventsourcing.test.data.events.MyEventValidator.isValid(com.mcf7.eventsourcing.test.data.events.CreateProfileEvent))")
    private void createProfile() {}

    @Before("createProfile()")
    public void logHere(JoinPoint joinPoint) {
        log.info("super cool log of: " + joinPoint.getArgs()[0]);
    }
}
