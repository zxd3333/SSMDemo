package ssm.mybatis1.dao;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import ssm.mybatis1.pojo.Student;
import ssm.mybatis1.utils.MyBatisUtil;

import java.util.List;

//测试类
public class StudentMapperTest {

    @Test
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
}
