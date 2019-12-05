package ssm.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ssm.spring.pojo.Student;

//基于Java的配置文件测试类
public class SpringConfigDemoTest {
    public static void main(String[] args) {
        //如果完全使用Java进行配置，就只能通过 AnnotationConfig 的上下文获取容器，通过配置类的class对象(SpringConfigDemo.class)加载
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfigDemo.class);
        Student student = context.getBean("getStudent", Student.class);
        System.out.println(student.toString());
    }
}
