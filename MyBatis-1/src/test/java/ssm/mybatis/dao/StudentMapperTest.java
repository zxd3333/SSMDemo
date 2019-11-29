package ssm.mybatis.dao;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import ssm.mybatis.pojo.Student;
import ssm.mybatis.utils.MyBatisUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//测试类
public class StudentMapperTest {

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

    @Test
    //使用Map，查找年龄为指定数字的学生
    public void test5(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("studentAge",10);
        List<Student> studentList = mapper.findByAge(map);
        for (Student s : studentList){
            System.out.println(s);
        }
        sqlSession.close();
    }

    @Test
    //模糊查询，查找名字中带有“一”的学生
    //在映射器中编写查询语句
    public void findStudent(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> studentList = mapper.findStudent("一");
        for (Student s : studentList){
            System.out.println(s);
        }
    }
}
