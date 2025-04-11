package scu.wcc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import scu.wcc.pojo.Address;
import scu.wcc.pojo.Result;
import scu.wcc.pojo.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
public class ResponseController {

    @RequestMapping("/helloworld")
    public Result getStr(){
        System.out.println("Hello World");
        return Result.success("Hello World");
    }

    @RequestMapping("/User")
    public Result getUser(){
        User user = new User("zhangsan",23,new Address("湖北","武汉"),null);

        return Result.success(user);
    }

    @RequestMapping("/array")
    public Result getArray(){

        return Result.success(new Integer[]{1,2,3});
    }

    @RequestMapping("/list")
    public Result getList(){
        List<User> userList = new ArrayList<>();

        User u1 = new User("zhangsan",23,null,null);
        User u2 = new User("lisi",24,null,null);
        User u3 = new User("wangwu",25,null,null);

        userList.add(u1);
        userList.add(u2);
        userList.add(u3);
        return Result.success(userList);
    }

}
