package com.itheima;

import com.itheima.controller.DeptController;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
class SpringbootWebConfig2ApplicationTests {

    //获取IOC容器对象
    @Autowired
    private ApplicationContext applicationContext;

    //获取bean对象
    @Test
    public void testGetBean(){
        //根据bean的名称获取
        DeptController bean1 =(DeptController) applicationContext.getBean("deptController");
        System.out.println(bean1);

        //根据bean的类型获取
        DeptController bean2 = applicationContext.getBean(DeptController.class);
        System.out.println(bean2);

        //根据bean的名称 及 类型获取
        DeptController bean3 = applicationContext.getBean("deptController", DeptController.class);
        System.out.println(bean3);

    }


    //bean的作用域
    @Test
    public void testScope(){

        for (int i = 0; i < 10; i++) {
            DeptController bean = applicationContext.getBean(DeptController.class);
            System.out.println(bean);
        }
    	
       
    }


    //第三方bean的管理
    @Autowired
    private SAXReader saxReader;


    @Test
    public void testThirdBean() throws Exception {
        //SAXReader saxReader = new SAXReader();

        Document document = saxReader.read(this.getClass().getClassLoader().getResource("1.xml"));
        Element rootElement = document.getRootElement();
        String name = rootElement.element("name").getText();
        String age = rootElement.element("age").getText();

        System.out.println(name + " : " + age);
    }

    @Test
    public void getBean(){

        for (int i = 0; i < 10; i++) {
            Object getReader = applicationContext.getBean("getReader");
            System.out.println(getReader);
        }


    }

}
