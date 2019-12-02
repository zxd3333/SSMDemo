package ssm.mybatis.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;
import ssm.mybatis.pojo.Student;
import ssm.mybatis.utils.MyBatisUtil;

import java.util.List;

public class StudentMapperTest {

    private static Logger logger = Logger.getLogger(StudentMapperTest.class);

    @Test
    //获取所有学生
    public void test(){
        //获得SqlSession对象
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> allStudent = mapper.findAllInfo();
        for (Student s : allStudent){
            System.out.println(s);
        }
        sqlSession.close();
    }

    @Test
    public void test1(){
        //获得SqlSession对象
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> allStudent = mapper.findAllStudentInfo();
        for (Student s : allStudent){
            System.out.println(s);
        }
        sqlSession.close();
    }
}
