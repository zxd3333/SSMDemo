package ssm.mybatis.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//学生类
//用于偷懒的lombok的使用，首先在设置中安装插件，其次在pom.xml中导入依赖，最后在代码中编写注解使用
//1.@Data：在实体类中自动生成  Getter()/Setter()  无参构造  toString()  hashCode()  equals()
//2.@AllArgsConstructor：生成带全部参数的构造方法
//3.@NoArgsConstructor：生成无参构造方法
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    private int sid;
    private String name;
    private int age;
}
