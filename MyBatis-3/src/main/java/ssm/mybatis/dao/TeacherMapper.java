package ssm.mybatis.dao;

import org.apache.ibatis.annotations.Param;
import ssm.mybatis.pojo.Teacher;

import java.util.List;

public interface TeacherMapper {

    List<Teacher> findAllInfoById(@Param("id") int id);
}
