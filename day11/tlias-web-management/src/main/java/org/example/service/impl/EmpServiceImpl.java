package org.example.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.example.mapper.EmpMapper;
import org.example.pojo.Emp;
import org.example.pojo.PageBean;
import org.example.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    EmpMapper  empMapper;

/*    @Override
    public PageBean getRecord(int page, int pageSize) {

        List<Emp> rows= empMapper.getRecords((page-1)*pageSize,pageSize);
        Long total = empMapper.getRecordCount();

        return new PageBean(total,rows);
    }*/

    @Override
    public PageBean getRecord( Integer page, Integer pageSize,String name, Short gender, LocalDate begin, LocalDate end) {

        PageHelper.startPage(page,pageSize);
//        List<Emp> list = empMapper.pageList();
        List<Emp> list = empMapper.conditionSelect(name, gender, begin, end);
        Page<Emp> pList = (Page<Emp>)list;

        return new PageBean(pList.getTotal(),pList.getResult());
    }

    @Override
    public void delete(List<Integer> ids) {

        empMapper.delete(ids);
    }

    @Override
    public void insert(Emp emp) {

        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());

        empMapper.insert(emp);


    }

    @Override
    public Emp selectByID(Integer id) {
        Emp emp = empMapper.selectByID (id);


        return emp;
    }

    @Override
    public void update(Emp emp) {
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.update(emp);
    }

    @Override
    public Emp login(Emp emp) {
        return empMapper.getUserByUsernameAndPassword(emp);

    }
}
