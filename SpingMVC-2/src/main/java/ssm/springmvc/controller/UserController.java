package ssm.springmvc.controller;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import ssm.springmvc.JsonUtils;
import ssm.springmvc.pojo.User;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController //相当于@ResponseBody + @Controller
public class UserController {

    // @ResponseBody 该注解表示不会走视图解析器，此处表示返回的就是字符串
    //此方法输出一个对象
    @RequestMapping("/h1")
    public String jackJsonTest1() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        User user = new User("赵",10,"男");
        String m = mapper.writeValueAsString(user);
        return m;
    }

    @RequestMapping("/h2")
    //此方法输出一个列表对象
    public String jackJsonTest2() throws JsonProcessingException {
        List<User> userList = new ArrayList<User>();
        User user1 = new User("赵",10,"男");
        User user2 = new User("赵",10,"男");
        User user3 = new User("赵",10,"男");
        User user4 = new User("赵",10,"男");
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);
//        ObjectMapper mapper = new ObjectMapper();
//        String m = mapper.writeValueAsString(userList);
//        return m;
        return JsonUtils.getJson(userList);
    }

    @RequestMapping("/h3")
    //此方法输出时间
    public String jackJsonTest3() throws JsonProcessingException {
//        ObjectMapper mapper = new ObjectMapper();
//        //直接输出时间会是一串数字，这里不使用时间戳
//        mapper.configure(SerializationFeature.WRITE_DURATIONS_AS_TIMESTAMPS,false);
//        //然后自定义时间格式
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        mapper.setDateFormat(sdf);
//
//        Date date = new Date();
//
//        return mapper.writeValueAsString(date);
        Date date = new Date();
        return JsonUtils.getJson(date,"yyyy-MM-dd HH:mm:ss");
    }

    @RequestMapping("/h4")
    //此方法使用fastjson
    public String jackJsonTest4() throws JsonProcessingException {
        List<User> userList = new ArrayList<User>();
        User user1 = new User("赵",10,"男");
        User user2 = new User("赵",10,"男");
        User user3 = new User("赵",10,"男");
        User user4 = new User("赵",10,"男");
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);

        String s = JSON.toJSONString(userList);
        return s;
    }
}
