package ssm.spring.annotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect  //表示这个类是一个切面
public class AnnotationDemo {

    //切入点和执行位置
    @Before("execution(* ssm.spring.service.StudentServiceImpl.*(..))")
    public void before(){
        System.out.println("方法执行前");
    }

    @After("execution(* ssm.spring.service.StudentServiceImpl.*(..))")
    public void after(){
        System.out.println("方法执行后");
    }

    @Around("execution(* ssm.spring.service.StudentServiceImpl.*(..))")
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("环绕前");
        //方法执行
        //下面这行代码的意思是开始执行切入点的方法
        proceedingJoinPoint.proceed();
        System.out.println("环绕后");
    }
}
