package ssm.mybatis.dao;

import ssm.mybatis.pojo.Student;

import java.util.List;
import java.util.Map;

public interface StudentMapper {
    //获取所有学生
    List<Student> getAll();
    //查找一个学生
    Student selectById(int sid);
    //添加一个学生
    void addStudent(Student student);
    //更新一个学生
    void updateStudent(Student student);
    //删除一个学生
    void deleteStudentById(int sid);

    //Map的初步使用
    List<Student> findByAge(Map<String,Object> map);

    //模糊查询的初步使用
    List<Student> findStudent(String name);
}