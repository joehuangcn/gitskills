package demo1.controller;

import demo1.entity.User;
import demo1.service.UserService;
import demo1.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("userControl")
public class UserController {
    @Autowired
    private UserServiceImpl userService;

    @RequestMapping(value = "/findOne")
    @ResponseBody
    public String findOne(@RequestParam String name){
        User user=userService.findByUsername(name);
        return user.getUsername();
    }
    @RequestMapping(value = "/saveOne")
    @ResponseBody
    public String findOne(){
        User user=new User();
        user.setId(2L);
        user.setUsername("tom");
        user.setPassword("123");
        User user1=userService.createUser(user);
        return user1.getUsername();
    }
}
