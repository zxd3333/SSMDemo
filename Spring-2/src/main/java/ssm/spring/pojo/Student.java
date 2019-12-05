package ssm.spring.pojo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

//此注解放在类名上方，就是把这个类注册到Spring容器中
//等价于<bean id = "student" class="ssm.spring.pojo.Student">
@Component
public class Student{

    //此注解可以放在属性定义上，也可以放在setXxx()方法上
    //等价于<property name = "name" value = "赵">
    @Value("赵")
    private String name;
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                '}';
    }
}
