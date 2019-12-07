package ssm.mapper;

import org.mybatis.spring.SqlSessionTemplate;
import ssm.pojo.Student;
import java.util.List;

public class StudentMapperImpl implements StudentMapper {

    //原来使用SqlSession，现在被SqlSessionTemplate代替了
    private SqlSessionTemplate sqlSessionTemplate;

    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    public List<Student> findAll() {
        StudentMapper mapper = sqlSessionTemplate.getMapper(StudentMapper.class);
        return mapper.findAll();
    }
}
