# 什么是MyBatis
* MyBatis是一款优秀的持久层框架
* 它的封装让开发者们只需关注sql语句本身
* 它支持定制化SQL、存储过程以及高级映射
* MyBatis避免了几乎所有的JDBC代码和手动设置参数以及获取结果集
* MyBatis可以使用简单的XML或注解来配置和映射原生类型、接口和Java的POJO（普通老式Java对象）为数据库中的记录。
# MyBatis入门
* 1、获得MyBatis：使用Maven构建项目，只需将下面的dependency代码置于pom.xml中
  ```xml
  <dependency>
    <groupId>org.mybatis</groupId>
    <artifactId>mybatis</artifactId>
    <version>3.4.6</version>
  </dependency>
  ```
* 2、持久化：将数据在持久状态和瞬时状态转化的过程
    * 通俗一点讲，就是将瞬时数据(例如内存中的数据，不能持久保存)持久化为持久数据(例如数据库，能够长久保存)
    * 持久化的例子
        * JDBC就是一种持久化机制
        * 文件IO也是持久化机制
    * 为什么要持久化？
        * 1.内存中的数据断电就会丢失，而有一些对象是不能丢失的
        * 2.内存太贵，有容量限制(太贵哈哈哈哈哈，真实)
* 3、持久层：完成持久化的代码块，负责数据库的访问
* 4、ORM思想：对象关系映射
    * 简而言之，就是把数据库的表与Java实体类对应，数据库的列就是Java实体类的属性
    * 我们通过操作实体类来实现操作数据库，中间的步骤交给MyBatis就行了
* 5、使用MyBatis的原因
    * 方便
    * 传统的JDBC代码太复杂了
    * 优点多：百度一下就能看到
        * 简单易学
        * 灵活，不会对应用程序和数据库强加影响，sql语句写在xml配置文件中，通过sql语句可以满足操作数据库的所有需求
        * 解除sql与程序的耦合：通过设计DAO层，将业务逻辑和数据访问分离开来，提高程序的可维护性
        * 提供映射标签，支持对象与数据库的字段关系映射
        * 提供xml标签
        * 用的人多(吼吼吼吼~)
        
# MyBatis的使用
* 1、创建数据库和数据表，确保IDEA可以连接上数据库

* 2、编写MyBatis的配置文件：myBatis-config.xml
    ```xml
  <?xml version="1.0" encoding="UTF-8" ?>
      <!DOCTYPE configuration
          PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
          "http://mybatis.org/dtd/mybatis-3-config.dtd">
  <!--核心配置-->
  <configuration>
      <!--环境，default设置默认环境，这里默认选择id为development的环境-->
      <environments default="development">
          <environment id="development">
              <!--事务管理-->
              <transactionManager type="JDBC"/>
              <!--设置数据源-->
              <dataSource type="POOLED">
                  <property name="driver" value="com.mysql.cj.jdbc.Driver"/>
                  <property name="url" value="jdbc:mysql://localhost:3306/school??useUnicode=true&amp;characterEncoding=utf8&amp;useSSL=false"/>
                  <property name="username" value="root"/>
                  <property name="password" value="root"/>
              </dataSource>
          </environment>
      </environments>
  </configuration>
    ```
* 3、从XML文件中构建SqlSessionFactory
    * 每个MyBatis的应用都是以一个SqlSessionFactory为核心的
    * SqlSessionFactory的实例可以通过SqlSessionFactoryBuilder来获得
    * SqlSessionFactoryBuilder则可以通过一个XML配置文件来构建SqlSessionFactory的实例

* 4、从SqlSessionFactory中获取SqlSession
    * SqlSession完全包含了面向数据库执行SQL命令的所有方法
    * 通过openSession()方法可以获取SqlSession的实例
    ```java
    public class MyBatisUtil {
        private static SqlSessionFactory sqlSessionFactory;
        //获取SqlSessionFactory对象
        static{
            try {
                String resource = "mybatis-config.xml";
                InputStream inputStream = Resources.getResourceAsStream(resource);
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //从SqlSessionFactory中获取SqlSession
        //SqlSession完全包含了面向数据库执行SQL命令的所有方法
        public static SqlSession getSqlSession(){
              //获取SqlSession实例，并返回一个SqlSession对象
    //        SqlSession sqlSession = sqlSessionFactory.openSession();
    //        return sqlSession;
            return sqlSessionFactory.openSession();
        }
    }
    ```
* 5、编码
    * 编写实体类
    * 编写接口
    * 编写接口映射器
        * 命名空间是指定的接口的全限定名，MyBatis上下文就可以通过命名空间找到对应的接口  
          这样该命名就可以直接映射到在命名空间中同名的xxxMapper接口，并将已映射的sql语句中的名字、参数和返回类型匹配成方法
          sql语句中的列名和实体类中的的属性是MyBatis自动映射的，需要保证一致
        * 编写完成后需要在mybatis-config.xml中进行注册
    
* 6、测试
    * 测试类中通过工具类获取SqlSession对象
    * SqlSession对象通过getMapper()方法获取xxxMapper接口动态代理对象  
    * 调用代理对象中的方法
    ```java
    public class StudentMapperTest {
      @Test
      public void test(){
          //获得SqlSession对象
          SqlSession sqlSession = MyBatisUtil.getSqlSession();
          //获得接口的代理对象
          StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
          //调用接口中的方法，获取返回结果
          List<Student> allStudent = mapper.getAll();
          for (Student s : allStudent){
              System.out.println(s);
          }
          sqlSession.close();
      }
    }
   ```