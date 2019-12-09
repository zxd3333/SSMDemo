package ssm.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//该注解的功能：将该类注册到SpringIOC容器中，同时声明该类是一个控制器
//添加该注解的类，如果返回值是String，并且有对应的页面可以跳转，就会被视图解析器解析
@Controller
public class HelloController{

    //此注解用于映射到url
    @RequestMapping("/h")
    public String hello(Model model){
        //封装数据，会在jsp页面取出并渲染
        model.addAttribute("msg","HelloMonday");
        //会被视图解析器处理
        //WEB-INF/jsp/hi.jsp
        return "hi";
    }

    //这个方法了解Result风格的url
    //原先的：http://localhost:8080/add?a=10&b=100
    //Result：http://localhost:8080/add/10/100
    //这里的@PathVariable 可以把方法参数的值绑定到url对应的变量上
    @RequestMapping("/add/{a}/{b}")
    public String test(Model model, @PathVariable int a,@PathVariable int b){
        int result = a + b;
        model.addAttribute("msg","结果为：" + result);
        return "hi";
//        重定向的方法
//        return "redirect:/index.jsp";
    }
}
