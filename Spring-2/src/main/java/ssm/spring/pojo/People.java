package ssm.spring.pojo;

import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;

public class People {

    private String name;

    //使用注解自动装配
    //1.@Autowired：使用byType的方式实现
    //2.@Resurce：先使用byName的方式实现，找不到名字就通过byType的方式实现，两种方法都找不到就报错

    @Resource
    private Cat cat;
    @Autowired
    private Dog dog;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Cat getCat() {
        return cat;
    }

    public void setCat(Cat cat) {
        this.cat = cat;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }
}
