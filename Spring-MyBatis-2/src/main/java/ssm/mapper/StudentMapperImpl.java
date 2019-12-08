package ssm.mapper;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import ssm.pojo.Student;

import java.util.List;

public class StudentMapperImpl extends SqlSessionDaoSupport implements StudentMapper{
    public List<Student> findAll() {


        //执行findAll方法时，会首先插入再删除一个学生
        //但是我们这里的sql故意写错了，所以一定会报错，但是插入的学生会不会已经进入数据库呢？
        //运行后发现会进入数据库
        //但是我们要保证一组事务 要成功就都成功，要失败就都失败
        //所以在这个findAAll方法中，如果代码出现错误，这个方法内所有对数据库有关的操作就不应该添加进数据库，于是就应用到了Spring的事务来解决
//        Student student = new Student(9,"孙一",20,2);
//        addStu(student);

        del(6);

        return getSqlSession().getMapper(StudentMapper.class).findAll();
    }

    public void addStu(Student student) {
        getSqlSession().getMapper(StudentMapper.class).addStu(student);
    }

    public void del(int id) {
        getSqlSession().getMapper(StudentMapper.class).del(id);
    }
}
