package scu.wcc;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import scu.wcc.mapper.EmpMapper;
import scu.wcc.pojo.Emp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
class SpringbootMybatisCrudApplicationTests {

    @Autowired
    EmpMapper empMapper ;

    @Test
    public void deleteTest(){
        empMapper.delete(16);
    }

    @Test
    public void insertTest(){
        Emp emp =new Emp();
        emp.setUsername("Tom2");
        emp.setName("汤姆2");
        emp.setGender((short) 1);
        emp.setImage("1.jpg");
        emp.setJob((short)2);
        emp.setEntrydate(LocalDate.of(2000,8,25));
        emp.setDeptId(2);
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());

        empMapper.insert(emp);

        System.out.println(emp.getId());
    }

    @Test
    public void updateTest(){
        Emp emp = new Emp();
        emp.setUsername("Tom4");
        emp.setName("汤姆4");
        emp.setGender((short) 1);
        emp.setImage("1.jpg");
        emp.setJob((short)2);
        emp.setEntrydate(LocalDate.of(2000,8,25));
        emp.setDeptId(2);
        emp.setUpdateTime(LocalDateTime.now());
        emp.setId(21);

        empMapper.update(emp);


    }


    @Test
    public void selectTest(){

        Emp emp = empMapper.select(2);

        System.out.println(emp);

    }

    @Test
    public void conditionSelectTest(){


        //List<Emp> list = empMapper.conditionSelect("张", 1, LocalDate.of(2000, 1, 1), LocalDate.of(2020, 1, 1));
        //List<Emp> list = empMapper.conditionSelect(null, (Short)null, null,null);
        List<Emp> list = empMapper.conditionSelect("张", (short)1, null,null);
        list.stream().forEach(System.out::println);

    }

    @Test
    public void updateTest2(){
        Emp emp = new Emp();
        emp.setUsername("Tom4");
        emp.setName("汤姆4");
        emp.setGender((short) 1);
        emp.setImage("1.jpg");
        emp.setJob((short)2);
        emp.setId(22);

        empMapper.update2(emp);
    }

    @Test
    public void deleteTest2(){
        List<Integer> list = Arrays.asList(15,21,22);

        empMapper.deleteByIds(list);
    }


}
