package ssm.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

    @PostMapping("/hello")
    public String test(Model model,String name){
        System.out.println(name);
        model.addAttribute("msg",name);
        return "hi";
    }
}
