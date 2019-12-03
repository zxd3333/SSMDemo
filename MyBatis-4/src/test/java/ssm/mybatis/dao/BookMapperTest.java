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

    //一级缓存：基于sqlSession的会话
    @Test
    public void test5(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        BookMapper mapper = sqlSession.getMapper(BookMapper.class);
        Map<String,Object> map = new HashMap<String, Object>();

        //我们查询一条数据，该数据就从数据库中拿到，然后会被放到当前会话的一级缓存中
        List<Book> bookList = mapper.findBook(map);
        for (Book book : bookList) {
            System.out.println(book);
        }
        //不进行任何操作，再次查询这条数据，会发现sql语句只执行了一次，第二次查询的数据是从一级缓存中取得的
        List<Book> bookList1 = mapper.findBook(map);
        for (Book book : bookList1) {
            System.out.println(book);
        }
        //1.如果查询不同的数据，例如第一个语句查名字，第二个语句查年龄，缓存会失效的
        //2.查询一次之后进行了增删改操作，那么缓存会被刷新，查询语句就又需要到数据库中拿到数据，并放在一级缓存中
        //3.手动清理缓存，缓存就会失效了(这简直就是废话) sqlSession.clearCache();
        sqlSession.close();
    }

    //二级缓存：
    //机制：一个会话(sqlSession1)查询一个数据，放在一级缓存中
    //      当前会话(sqlSession1.close())关闭后，缓存就没了，开启二级缓存后，数据会保存在二级缓存中
    //      新的会话(sqlSession2)会从二级缓存中获取内容
    @Test
    public void test6(){
        SqlSession sqlSession1 = MyBatisUtil.getSqlSession();


        BookMapper mapper1 = sqlSession1.getMapper(BookMapper.class);
        Map<String,Object> map = new HashMap<String, Object>();
        List<Book> bookList1 = mapper1.findBook(map);
        for (Book book : bookList1) {
            System.out.println(book);
        }
        sqlSession1.close();

        //从二级缓存中拿到数据
        SqlSession sqlSession2 = MyBatisUtil.getSqlSession();
        BookMapper mapper2 = sqlSession2.getMapper(BookMapper.class);
        List<Book> bookList2 = mapper2.findBook(map);
        for (Book book : bookList2) {
            System.out.println(book);
        }
        sqlSession2.close();

    }
}
