package ssm.mybatis.dao;

import ssm.mybatis.pojo.Student;

import java.util.List;

public interface StudentMapper {

    List<Student> findAllInfo();
    List<Student> findAllStudentInfo();
}
