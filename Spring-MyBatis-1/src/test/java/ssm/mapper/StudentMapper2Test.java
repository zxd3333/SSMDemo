package ssm.mapper;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ssm.pojo.Student;

import java.util.List;

public class StudentMapper2Test {

    @Test
    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        StudentMapperImpl2 u2 = context.getBean("u2", StudentMapperImpl2.class);
        List<Student> all = u2.findAll();
        for (Student student : all) {
            System.out.println(student);
        }
    }
}
