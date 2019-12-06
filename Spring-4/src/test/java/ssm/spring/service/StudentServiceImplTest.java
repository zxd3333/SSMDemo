package ssm.spring.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StudentServiceImplTest {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //此处注意，动态代理代理的是接口，而不是其实现类
        StudentService studentService = context.getBean("studentServiceImpl", StudentService.class);
        studentService.select();
    }

}
