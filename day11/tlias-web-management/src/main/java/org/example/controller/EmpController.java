package org.example.controller;


import jakarta.websocket.server.PathParam;
import org.example.anno.Log;
import org.example.pojo.Emp;
import org.example.pojo.PageBean;
import org.example.pojo.Result;
import org.example.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/emps")
public class EmpController {
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(DeptController.class);


    @Autowired
    EmpService empService;


    @GetMapping
    public Result getPage(@RequestParam(defaultValue = "1") Integer page,
                          @RequestParam(defaultValue = "10") Integer pageSize,
                          @RequestParam(required = false) String  name, @RequestParam(required = false)Short gender,
                          @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,
                          @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end){
        log.info("分页查询，参数：{},{},{},{},{},{}",name,gender,begin,end,page,pageSize);
        PageBean pageBean= empService.getRecord(page,pageSize,name,gender,begin,end);

       return Result.success(pageBean);
    }

    @Log
    @DeleteMapping("/{ids}")
    public Result delete(@PathVariable List<Integer> ids){

        empService.delete(ids);
        return Result.success();
    }

    @Log
    @PostMapping
    public Result insert(@RequestBody Emp emp){

        log.info("新增员工：{}",emp);
        empService.insert(emp);
        return Result.success();

    }

    @GetMapping("/{id}")
    public Result selectByID(@PathVariable Integer id){

        log.info("根据ID查询员工信息：{}",id);
       Emp emp =  empService.selectByID(id);
        return Result.success(emp);
    }

    @Log
    @PutMapping
    public Result update(@RequestBody Emp emp){
        empService.update(emp);

        return Result.success();
    }
}
