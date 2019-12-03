package ssm.mybatis.dao;

import ssm.mybatis.pojo.Book;

import java.util.List;
import java.util.Map;

public interface BookMapper {

    void addBook(Book book);

    //动态SQL：if,where的使用
    List<Book> findBook(Map map);

    //动态SQL：where,choose,when,otherwise的使用
    List<Book> chooseBook(Map map);

    //动态SQL：set,if的使用
    void updateBook(Map map);

    //动态SQL：foreach的使用
    List<Book> foreachBook(Map map);
}
