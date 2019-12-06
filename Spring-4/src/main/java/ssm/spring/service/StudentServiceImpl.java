package ssm.spring.service;

import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {
    public void select() {
        System.out.println("查询一个用户");
    }

    public void insert() {
        System.out.println("插入一个用户");
    }

    public void update() {
        System.out.println("更新一个用户");
    }

    public void delete() {
        System.out.println("删除一个用户");
    }
}
