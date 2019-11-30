# MyBatis-config.xml配置的了解以及优化
* configuration配置  
    * properties(属性)  
    * settings(设置)  
    * typeAliases(类型别名)  
    * typeHandlers(类型处理器)  
    * objectFactory(对象工厂)  
    * plugins(插件) 
    * environments(环境配置)  
        * environment(环境变量)  
            * transactionManager(事务管理器)  
            * dataSource(数据源)  
    * databaseIdProvider(数据库厂商标识)  
    * mappers(映射器)

## properties(属性)
* 通过properties引用外部配置文件，一般就是jdbc.properties
```xml
<!--可以直接引用外部配置文件，里面的<property>标签可以不写-->
    <properties resource="jdbc.properties">
        <!--如果<property>标签里面配置了属性，外部文件可以不写对应的属性
            但是如果两者重复，优先使用外部文件的配置-->
        <property name="username" value="root"/>
        <property name="password" value="123456"/>
    </properties>
```
## settings(设置)
* settings中有很多属性，它们会改变MyBatis的运行时行为
* 了解一下logImpl：指定MyBatis所用日志的具体实现，未指定时将自动查找。可以设置的有好几种
    * SLF4J、LOG4J
    * LOG4J2
    * JDK_LOGGING
    * COMMONS_LOGGING
    * STDOUT_LOGGING
    * NO_LOGGING
## typeAliases(类型别名)
* 类型别名是为Java类型设置一个短的名字，它存在的意义仅在于用来减少类完全限定名的冗余
    * 第一种方法：给一个实体类起一个别名
    ```xml
    <typeAliases>
        <typeAlias type="ssm.mybatis.pojo.Student" alias="Student"/>
    </typeAliases>
    ```
    * 第二种方法：可以指定一个包名，指定包名时，MyBatis会在包下搜索需要的实体类
    ```xml
    <typeAliases>
        <package name="ssm.mybatis.pojo"/>
    </typeAliases>
    ```
    如果实体类有注解的话，可以在注解中设置实体类的别名。
    ```java
    //使用注解，设置Student类的别名为Student，之后在xml文件中，ssm.mybatis.pojo.Student就可以替换为Student
    @Alias("Student")
    public class Student{
    }
    ```
    如果实体类没有注解，会默认使用类名首字母小写的形式当做别名，即student
## typeHandlers(类型处理器)--知道有这个东西就好，不用了解，因为可能用不上
## objectFactory(对象工厂)--知道有这个东西就好，不用了解
## plugins(插件)--知道有这个东西就好，不用了解
## environments(环境配置)
* MyBatis可以配置多个环境以适应不同的需求，这种机制的好处：
    * 可以满足开发、测试和生产环境需要的不同的配置
    * 可以将sql映射应用于多种数据库之中
* 尽管可以配置多个环境，但每个SqlSessionFactory实例只能选择一种环境 
* environment(环境变量)：定义了如何配置环境，包括事务管理器和数据源
    * transactionManager(事务管理器)：在MyBatis中有两种类型的事务管理器：type = "JDBC"(常用) 和 type = "MANAGED"(不常用)
        * 这里默认的是JDBC
    * dataSource(数据源)：连接数据库：在MyBatis中有三种内建的数据源类型：type = "UNPOOLED"(没有连接池) 和 type = "POOLED"(连接池，好处是可以回收) 和 type = "JNDI"(不常用)
        * 这里默认的是POOLED
## mappers(映射器)
* 注意一个错误："...is not known to the MapperRegistry."意思是没有注册接口对应的.xml文件
    * 遇到这个错误，检查mybatis-config.xml配置里面<mappers>标签，再检查接口对应的.xml文件的命名空间(namespace)
* 定义sql映射语句，有四种方法，这里介绍三种，但是只推荐使用第一种方法
    * 第一种方法：使用相对于类路径的资源引用
    ```xml
        <mappers>
          <mapper resource="ssm/mybatis/dao/StudentMapper.xml"/>
        </mappers>
    ```
    * 第二种方法：使用class文件绑定注册  
    注意点：接口(StudentMapper)和它的映射配置文件(StudentMapper.xml)必须同名，且在同一个包下
    ```xml
        <mappers>
            <mapper class="ssm.mybatis.dao.StudentMapper"/>
        </mappers>
    ```
    * 第三种方法：使用扫描包进行注入绑定  
    注意点：接口(StudentMapper)和它的映射配置文件(StudentMapper.xml)必须同名，且在同一个包下
    ```xml
        <mappers>
            <package name="ssm.mybatis.dao"/>
        </mappers>
    ```
  
    
    
