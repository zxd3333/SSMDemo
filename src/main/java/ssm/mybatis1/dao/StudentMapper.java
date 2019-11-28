package ssm.mybatis1.dao;

import ssm.mybatis1.pojo.Student;

import java.util.List;

public interface StudentMapper {
    List<Student> getAll();
}
