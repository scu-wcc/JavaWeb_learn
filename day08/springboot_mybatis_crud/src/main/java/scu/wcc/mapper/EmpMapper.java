package scu.wcc.mapper;

import org.apache.ibatis.annotations.*;
import scu.wcc.pojo.Emp;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface EmpMapper {

    @Delete("delete from emp where id=#{id}")
    public void delete(@Param("id") Integer id);

    @Options(keyProperty = "id", useGeneratedKeys = true)
    @Insert("insert into emp(username, name, gender, image, job, entrydate, dept_id, create_time, update_time)" +
            "VALUES(#{username},#{name},#{gender},#{image},#{job},#{entrydate},#{deptId},#{createTime},#{updateTime})")
    public void insert(Emp emp);

    @Update("update emp set username=#{username},name=#{name},gender=#{gender},image=#{image},job=#{job}," +
            "entrydate=#{entrydate}, dept_id=#{deptId},update_time=#{updateTime} where id=#{id} ")
    public void update(Emp emp);

    //根据主键查询
    @Select("select * from emp where id=#{id}")
    public Emp select(Integer id);

    //别名
/*    @Select("select id, username, password, name, gender, image, job, entrydate, dept_id deptId, create_time createTime, update_time updateTime from emp where id=#{id}")
    public Emp select(Integer id);*/

    //@Result 手动映射
/*    @Select("select * from emp where id=#{id}")
    @Results({
            @Result(column = "dept_id",property = "deptId"),
            @Result(column = "create_time",property = "createTime"),
            @Result(column = "update_time",property = "updateTime"),
    })
    public Emp select(Integer id);*/


    //根据条件查询

    /*    @Select("select * from emp where name like concat('%',#{name},'%') and gender = #{gender} and entrydate between #{start} and #{end} order by update_time;")
        public List<Emp> conditionSelect(String name, int gender, LocalDate start, LocalDate end);*/
    public List<Emp> conditionSelect(String name, Short gender, LocalDate start, LocalDate end);


    public void update2(Emp emp);

    public void deleteByIds(List<Integer> ids);

}
