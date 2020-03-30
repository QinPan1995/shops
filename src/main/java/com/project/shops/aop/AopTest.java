package com.project.shops.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * @author qinpan
 * @create 2020-02-28 12:05
 */
@Aspect
@Component
public class AopTest {
    //private static final Logger logger = Logger.getLogger(AopTest.class);   //日志，我用的log4j

    //配置切点
    @Pointcut("execution(* com.project.shops.controller.*.*(..))")
    public void log() {
    }

    @Before("log()")  //前置通知
    public void beforeExcution(JoinPoint joinPoint) {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        /*logger.info("前置通知开启=====================");

        logger.info("URL : " + request.getRequestURL().toString());
        logger.info("HTTP_METHOD : " + request.getMethod());
        logger.info("IP : " + request.getRemoteAddr());
        logger.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        logger.info("ARGS : " + Arrays.toString(joinPoint.getArgs()));
        logger.info("前置通知结束=====================");*/
        System.out.println("进入Controller前");
    }

    @AfterReturning(returning = "ret", pointcut = "log()")  //后置返回
    public void doAfterReturning(Object ret) throws Throwable {
        // 处理完请求，返回内容
        /*logger.info("RESPONSE : " + ret);*/
    }

    @AfterReturning(value = "execution(* com.project.shops.controller.*.*(..))",returning = "keys")
    public void doAfterReturningAdvice1(JoinPoint joinPoint,Object keys){
        System.out.println("第一个后置返回通知的返回值1："+keys);
        System.out.println("第一个后置返回通知的返回值2："+keys);
    }


}
