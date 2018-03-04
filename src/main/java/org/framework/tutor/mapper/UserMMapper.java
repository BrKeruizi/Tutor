package org.framework.tutor.mapper;

import org.apache.ibatis.annotations.*;
import org.framework.tutor.domain.UserMain;

import java.util.List;

/**
 * 用户主表数据访问层
 * @author chengxi
 */
@Mapper
public interface UserMMapper {

    /**
     * 根据用户名获取并返回对应的用户
     * @param username
     * @return
     */
    @Select("select * from user_main where username = #{username}")
    UserMain getByUsername(@Param("username") String username);

    /**
     * 根据用户名和密码获取并返回对应的用户
     * @param username
     * @param password
     * @return
     */
    @Select("select * from user_main where username= #{username} and password = #{password}")
    UserMain getByUserPass(@Param("username") String username, @Param("password") String password);

    /**
     * 根据昵称获取并返回对应的用户
     * @param nickname
     * @return
     */
    @Select("select * from user_main where nickname = #{nickname}")
    UserMain getByNickname(@Param("nickname") String nickname);

    /**
     * 添加/注册新用户
     * @param identity
     * @param username
     * @param password
     * @param nickname
     */
    @Insert("insert into user_main(identity,username, password, nickname) values(#{username},#{password},#{nickname})")
    Integer addUser(@Param("identity") Integer identity,@Param("username") String username,
                    @Param("password") String password, @Param("nickname") String nickname);

    /**
     * 更换指定用户的头像
     * @param username
     * @param imgsrc
     * @return
     */
    @Update("update user_main set imgsrc = #{imgsrc} where username = #{username}")
    boolean modImgsrcByUser(@Param("username") String username, @Param("imgsrc") String imgsrc);

    /**
     * 更改用户的个人信息
     * @param username
     * @param nickname
     * @param sex
     * @param age
     * @param info
     * @return
     */
    @Update("update user_main set nickname = #{nickname}, sex = #{sex}, age = #{age}, info = #{info} where username = #{username}")
    boolean modUserinfo(@Param("username") String username, @Param("nickname") String nickname, @Param("sex") Integer sex,
                        @Param("age") Integer age, @Param("info") String info);
}
