package ssm.mapper;

import ssm.pojo.Student;

import java.util.List;

public interface StudentMapper {
    List<Student> findAll();

    void addStu(Student student);

    void del(int id);
}
