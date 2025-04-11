package scu.wcc.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import scu.wcc.pojo.User;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

// 请求处理类
@RestController
public class HelloController {

    //将请求路径与处理请求的方法绑定
    @RequestMapping("/hello")
    public String hello(){
        System.out.println("Hello world!");
        return "Hello world!";
    }

/*    @RequestMapping("/simplePara")
    public String getPare(HttpServletRequest request){
        String name = request.getParameter("name");
        String strAge = request.getParameter("age");
        int age = Integer.parseInt(strAge);

        System.out.println(name + " : "+ age);

        return "OK";
    }*/
    @RequestMapping("/simplePara")
    public String getPare(@RequestParam(value = "username", required = false) String name, Integer age){

        System.out.println(name + " : "+ age);

        return "OK";
    }

    @RequestMapping("/complexPojo")
    public String getPojo(User user){
        System.out.println(user);

        return "OK";
    }

    @RequestMapping("/arrayParam")
    public String getArray(String[] hobby){

        System.out.println(Arrays.toString(hobby));

        return "OK";
    }

    @RequestMapping("/listParam")
    public String getArray(@RequestParam List<String> hobby){
        System.out.println(hobby);
        return "OK";
    }

    @RequestMapping("/timeParam")
    public String getTime(@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime nowTime){
        System.out.println(nowTime);
        return "OK";
    }

    @RequestMapping("/jsonParam")
    public String getJSON(@RequestBody User user){
        System.out.println(user);
        return "OK";
    }

    @RequestMapping("/path/{id}/{name}")
    public String getPath(@PathVariable Integer id, @PathVariable String name){

        System.out.println(id);
        System.out.println(name);
        return "OK";
    }

/*    @RequestMapping("/path2/{id}/{name}")
    public String getPath2(@PathVariable Integer id, @PathVariable String name){

        System.out.println(id);
        System.out.println(name);
        return "OK2";
    }*/

}
