package ssm.mybatis1.dao;

import ssm.mybatis1.pojo.Student;

import java.util.List;

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
}
