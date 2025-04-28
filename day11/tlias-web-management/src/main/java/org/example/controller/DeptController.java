package org.example.controller;



import org.example.anno.Log;
import org.example.pojo.Dept;
import org.example.pojo.Result;
import org.example.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/depts")
@RestController
public class DeptController {

    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(DeptController.class);

    @Autowired
    private DeptService deptService;


//    @RequestMapping(value = "/depts",method = RequestMethod.GET)
    @GetMapping
    public Result deptList(){

        List<Dept> deptList = deptService.list();

        log.info("查询全部部门信息");
        return Result.success(deptList);
    }

    @Log
    @DeleteMapping("/{id}")
    public Result deptDelete(@PathVariable Integer id){

        log.info("根据id删除部门:{}",id);
        deptService.delete(id);

        return Result.success("success");
    }

    @Log
    @PostMapping
    public Result deptInsert(@RequestBody Dept dept){

        log.info("添加部门:{}",dept);
        deptService.insert(dept);
        return Result.success();

    }


    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id){


        log.info("查询Id:{}",id);
        Dept dept =  deptService.getById(id);

       return Result.success(dept);
    }

    @Log
    @PutMapping
    public Result update(@RequestBody Dept dept){

        log.info("修改部门：{}",dept);

        deptService.update(dept);
        return Result.success();
    }
}
