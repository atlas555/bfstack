package com.bf.blog.mapper;

import com.bf.blog.domain.User;

import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {

    String TABLE = "jb_users";

    String COL_ALL_WITHOUT_KEY = "login_name, password, name, url, status, register_date, update_date";
    String BRIEF = "id,name, url";

    String COL_ALL = "id," + COL_ALL_WITHOUT_KEY;

    @Select("select " + COL_ALL + " from " + TABLE + " where id=#{userId}")
    public User getUserById(long userId);

    @Select("select " + BRIEF + " from " + TABLE + " where id=#{userId}")
    public User getUserBriefById(long userId);

    @Insert("insert into " + TABLE + " (" + COL_ALL_WITHOUT_KEY
            + ") values (#{loginName},#{password},#{name},#{status},now(),now() )")
    public int insertUser(User user);

    @Select("select * from jb_users where token = #{token}")
    User getUserByToken(@Param("token") String token);

    @Update("")
    void updateToken(long id, String s);
}
