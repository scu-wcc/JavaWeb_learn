package org.example.mapper;


import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.pojo.Emp;
import org.example.pojo.PageBean;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface EmpMapper {


    @Select("select * from emp limit #{index},#{pageSize}")
    List<Emp> getRecords(int index, int pageSize);

    @Select("select count(*) from emp")
    Long getRecordCount();

    @Select("select * from emp")
    List<Emp> pageList();

    List<Emp> conditionSelect(String name, Short gender, LocalDate begin, LocalDate end);

    void delete(List<Integer> ids);

    void insert(Emp emp);

    @Select("select * from emp where id=#{id}")
    Emp selectByID(Integer id);

    void update(Emp emp);

    @Select("select * from emp where username=#{username} and password=#{password}")
    Emp getUserByUsernameAndPassword(Emp emp);

    @Delete("delete from emp where dept_id=#{deptId}")
    void deleteByDeptId(Integer deptId);
}
