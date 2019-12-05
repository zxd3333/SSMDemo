package ssm.spring;

//使用JavaConfig配置Spring，完全不需要xml配置文件
//使用Java配置，主要就是各种注解的应用


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import ssm.spring.pojo.Student;

//通过之前看的注解，很容易知道 @Component 是把一个类注册到Spring容器中
//我们现在添加的这个配置类也会由Spring托管，注册到Spring容器中，因为点进去源码会看到 Configuration上面也有 @Component
//此注解代表这是一个配置类，就相当于applicationContext.xml
@Configuration
//此注解添加后，会扫描指定包下的所有类
@ComponentScan("ssm.spring.pojo")
// @Import(xxx.class)如果有多个配置类，可以通过@Import将配置类引入，汇总为一个
public class SpringConfigDemo {

    //此注解就是注册一个bean，相当于之前的一个<bean>标签
    //方法名就是id中的内容
    //返回值就是class中的内容
    @Bean
    public Student getStudent(){
        //返回要注入bean的对象
        return new Student();
    }
}
