package ssm.mybatis.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;
import ssm.mybatis.pojo.Book;
import ssm.mybatis.utils.IDUtil;
import ssm.mybatis.utils.MyBatisUtil;

import java.math.BigDecimal;
import java.util.*;

public class BookMapperTest {

    private static Logger logger = Logger.getLogger(BookMapperTest.class);

    @Test
    public void test(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        BookMapper mapper = sqlSession.getMapper(BookMapper.class);

        Book book = new Book();

        book.setId(IDUtil.gerId());
        book.setName("语文");
        book.setCreateTime(new Date());
        book.setAuthor("莫言");
        book.setPrice(new BigDecimal(new String("38.99")));
        mapper.addBook(book);

        book.setId(IDUtil.gerId());
        book.setName("数学");
        book.setCreateTime(new Date());
        book.setAuthor("华罗庚");
        book.setPrice(new BigDecimal(new String("37.99")));
        mapper.addBook(book);

        book.setId(IDUtil.gerId());
        book.setName("英语");
        book.setCreateTime(new Date());
        book.setAuthor("李华");
        book.setPrice(new BigDecimal(new String("28.99")));
        mapper.addBook(book);

        sqlSession.close();
    }

    @Test
    public void test1(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        BookMapper mapper = sqlSession.getMapper(BookMapper.class);
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("author","李华");
        List<Book> bookList = mapper.findBook(map);
        for (Book book : bookList) {
            System.out.println(book);
        }
        sqlSession.close();
    }

    @Test
    public void test2(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        BookMapper mapper = sqlSession.getMapper(BookMapper.class);
        Map<String,Object> map = new HashMap<String, Object>();
        //map.put("name","语文");
        map.put("author","莫言");
        List<Book> bookList = mapper.chooseBook(map);
        for (Book book : bookList) {
            System.out.println(book);
        }
        sqlSession.close();
    }

    @Test
    public void test3(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        BookMapper mapper = sqlSession.getMapper(BookMapper.class);
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("name","诗词");
        map.put("author","李白");
        map.put("id","a1344cf2799b41a695f8633abf9e89f2");
        mapper.updateBook(map);
        sqlSession.close();
    }

    @Test
    public void test4(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        BookMapper mapper = sqlSession.getMapper(BookMapper.class);
        Map<String,Object> map = new HashMap<String, Object>();
        //由于在xml中运用了foreach标签，传入了一个集合，所以需要在map中传一个集合
        ArrayList<String> name = new ArrayList<String>();
        name.add("诗词");
        name.add("英语");
        map.put("names",name);
        List<Book> bookList = mapper.foreachBook(map);
        for (Book book : bookList) {
            System.out.println(book);
        }
        sqlSession.close();
    }
}
