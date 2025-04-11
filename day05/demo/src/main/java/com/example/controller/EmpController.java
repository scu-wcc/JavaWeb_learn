package com.example.controller;


import com.example.pojo.Emp;
import com.example.pojo.Result;
import com.example.service.EmpService;
import com.example.service.impl.EmpServiceA;
import com.example.service.impl.EmpServiceB;
import com.example.utils.XmlParserUtils;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmpController {

    @Resource(name = "serviceB")
   /* @Autowired
    @Qualifier("serviceA")*/
    private EmpService service ;

   /* @RequestMapping("/listEmp")
    public Result getEmp(){
        String file = this.getClass().getClassLoader().getResource("emp.xml").getFile();
        List<Emp> list = XmlParserUtils.parse(file, Emp.class);

        list.stream().forEach(emp->{
            String gender = emp.getGender();
            if("1".equals(gender)){
                emp.setGender("男");
            }else if("2".equals(gender)){
                emp.setGender("女");
            }

            String job = emp.getJob();
            if("1".equals(job)){
                emp.setJob("讲师");
            }else if("2".equals(job)){
                emp.setJob("班主任");
            }else if ("3".equals(job)){
                emp.setJob("就业指导");
            }

        });

        return Result.success(list);

    }*/

    @RequestMapping("/listEmp")
    public Result getEmp(){
       List<Emp> list = service.listEmp();

        return Result.success(list);

    }

}
