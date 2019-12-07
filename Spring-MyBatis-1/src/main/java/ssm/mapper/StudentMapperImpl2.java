package ssm.mapper;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import ssm.pojo.Student;

import java.util.List;

//可以让实现类继承SqlSessionDaoSupport
//就可以直接调用getSqlSession()获得sqlSession了
//跟上一种方法比较，不用注入了
public class StudentMapperImpl2 extends SqlSessionDaoSupport implements StudentMapper{
    public List<Student> findAll() {
        SqlSession sqlSession = getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        return mapper.findAll();

        //上面的代码等价于下面
        // return getSqlSession().getMapper(StudentMapper.class).findAll();
    }
}
