# IOC：控制反转
* 控制反转是一种思想，DI(依赖注入)是它的一种实现方法  
* 控制反转，它反转的是获得依赖对象的过程

* 解析：
    * 1.之前创建对象，是由程序员在程序中创建，通过Student s = new Student();来创建
    * 2.使用Spring后，对象是由Spring创建的，对象的属性也是由Spring容器设置的，程序员在容器中配置后就可以使用，不需要new对象
# DI：依赖注入
* 简单了解
    * 依赖：bean对象的创建依赖于Spring容器
    * 注入：bean对象中的所有属性由Spring容器注入
    * 由IOC容器动态的将某个依赖关系注入到组件当中
    * 依赖注入还是利用实体类中的setXxx()方法进行注入的
* 注入方式：
    * 构造器注入
    * Set注入
    * 其他注入

# applicationContext.xml：配置文件
* 配置文件加载后，容器中管理的对象全部都会被初始化(执行无参构造方法)
* 标签：
  ```xml
  <?xml version="1.0" encoding="UTF-8"?>
  <beans xmlns="http://www.springframework.org/schema/beans"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://www.springframework.org/schema/beans
          http://www.springframework.org/schema/beans/spring-beans.xsd">
      <!--给id为stu的属性起别名，别名可以随意，访问时也可以通过别名访问-->
      <alias name="stu" alias="abc"/>
  
      <!--id：bean的唯一标识，同时也是class指定的类的一个对象名
          class：bean对象所对应的全限定名：包名+类名
          name：也是别名，同时可以起多个别名，访问时也可以通过别名访问，这就显得<alias>标签没什么作用啊哈哈哈哈-->
      <bean id="stu" class="ssm.spring.pojo.Student" name="student,s1,s2">
      </bean>
      <!--将多个配置文件导入合并为一个总的-->
      <import resource="bean1.xml"/>
      <import resource="bean2.xml"/>
      <import resource="bean3.xml"/>
  </beans>
  ```
