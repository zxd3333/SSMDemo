package ssm.mybatis.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;
import org.junit.Test;
import ssm.mybatis.pojo.Teacher;
import ssm.mybatis.utils.MyBatisUtil;

import java.util.List;

public class TeacherMapperTest {

    private static Logger logger = Logger.getLogger(TeacherMapperTest.class);

    @Test
    public void test(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        List<Teacher> all = mapper.findAll();
        for (Teacher teacher : all) {
            System.out.println(teacher);
        }
        sqlSession.close();
    }
}
