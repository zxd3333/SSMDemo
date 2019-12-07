package ssm.mapper;

import ssm.pojo.Student;

import java.util.List;

public interface StudentMapper {
    List<Student> findAll();

    void add(Student student);

    void del(int id);
}
