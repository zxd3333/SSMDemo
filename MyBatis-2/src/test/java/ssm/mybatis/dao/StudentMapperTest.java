package ssm.mybatis.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;
import ssm.mybatis.pojo.Student;
import ssm.mybatis.utils.MyBatisUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//测试类
public class StudentMapperTest {

    private static Logger logger = Logger.getLogger(StudentMapperTest.class);

    @Test
    //获取所有学生
    public void test(){
        //获得SqlSession对象
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> allStudent = mapper.getAll();
        for (Student s : allStudent){
            System.out.println(s);
        }
        sqlSession.close();
    }

    @Test
    //根据学号获取学生
    public void test1(){
        logger.info("进入方法：根据学号获取学生信息");
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        Student student = mapper.selectById(1);
        System.out.println(student);
        sqlSession.close();
    }

    @Test
    //添加一个学生
    public void test2(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        Student student = new Student(10,"老人",100);
        mapper.addStudent(student);
        System.out.println(student);
        //对数据库有更新时必须提交事务
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    //根据学号更新一个学生
    public void test3(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        Student student = new Student(10,"错误的人",666);
        mapper.updateStudent(student);
        System.out.println(student);
        //对数据库有更新时必须提交事务
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    //根据学号删除一个学生
    public void test4(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        mapper.deleteStudentById(10);
        //对数据库有更新时必须提交事务
        sqlSession.commit();
        sqlSession.close();
    }
}
