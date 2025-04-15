package scu.wcc.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import scu.wcc.pojo.User;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("select * from user")
    public List<User> getUserList();

}
