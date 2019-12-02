package ssm.mybatis.dao;

import ssm.mybatis.pojo.Teacher;

import java.util.List;

public interface TeacherMapper {

    List<Teacher> findAll();
}
