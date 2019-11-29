package ssm.mybatis.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

//MyBatis工具类
//SqlSessionFactory -> sqlSession
public class MyBatisUtil {
    //每个MyBatis的应用都是以一个SqlSessionFactory为核心的
    //SqlSessionFactory的实例可以通过SqlSessionFactoryBuilder来获得
    //SqlSessionFactoryBuilder可以通过在一个XML配置文件中构建出SqlSessionFactory的实例

    private static SqlSessionFactory sqlSessionFactory;
    //获取SqlSessionFactory对象
    static {
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

