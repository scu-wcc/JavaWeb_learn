package com.itheima;

import com.example.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;


//@ComponentScan({"com.example","com.itheima"})
//@Import({TokenParser.class})
//@Import({HeaderConfig.class})
//@Import({MyImportSelector.class})
@EnableHeaderConfig
@SpringBootApplication
public class SpringbootWebConfig2Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootWebConfig2Application.class, args);
    }

}
