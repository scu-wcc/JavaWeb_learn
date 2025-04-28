package org.example.service;

import org.example.pojo.Emp;
import org.example.pojo.PageBean;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public interface EmpService {
    PageBean getRecord(Integer page, Integer pageSize,String name, Short gender, LocalDate begin, LocalDate end);

    void delete(List<Integer> ids);

    void insert(Emp emp);

    Emp selectByID(Integer id);

    void update(Emp emp);

    Emp login(Emp emp);
}
