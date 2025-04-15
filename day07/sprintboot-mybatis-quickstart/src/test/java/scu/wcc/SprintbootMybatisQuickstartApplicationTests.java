package scu.wcc;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import scu.wcc.mapper.UserMapper;
import scu.wcc.pojo.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@SpringBootTest
class SprintbootMybatisQuickstartApplicationTests {

    @Autowired
    UserMapper userMapper ;

    @Test
    public void userTest(){
        List<User> userList = userMapper.getUserList();


        userList.stream().forEach(System.out::println);

    }

    @Test
    public void JDBCTest() throws ClassNotFoundException, SQLException {
        //1.连接驱动
        Class.forName("com.mysql.jdbc.Driver");

        //2.获取连接
        String url = "jdbc:mysql://localhost:3306/mybatis";
        String username ="root";
        String password="Wcc1047532566";
        Connection conn= DriverManager.getConnection(url,username,password);

        //3.获取执行SQL对象的Statement，执行SQL
        String sql="select * from user";
        Statement statement=conn.createStatement();
        ResultSet resultSet=statement.executeQuery(sql);
        List<User> list=new ArrayList<>();
        while (resultSet.next()){
            Integer id = resultSet.getInt("id");
            String name=resultSet.getString("name");
            Short age = resultSet.getShort("age");
            Short gender = resultSet.getShort("gender");
            String phone = resultSet.getString("phone");
            User user = new User(id,name,age,gender,phone);

            list.add(user);
        }

        //4.释放资源
        statement.close();
        conn.close();


        //5.遍历集合
        list.stream().forEach(System.out::println);



    }

}
