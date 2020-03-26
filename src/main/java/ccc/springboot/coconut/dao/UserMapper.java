package ccc.springboot.coconut.dao;

import ccc.springboot.coconut.model.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Mapper
// issue with intellj, need add this repository to solve the issue.
@Repository
public interface UserMapper {
  @Select("select * from tb_user")
  List<User> getAllUsers();

  @Select("select * from tb_user t where t.id = #{id}")
  Optional<User> getUserById(Integer id);

  @Insert(
      "INSERT INTO tb_user(tb_user.username, tb_user.address) VALUES (#{userName}, #{address})")
  void addUser(String userName, String address);

  @Delete("delete from tb_user where id = #{id}")
  void delete(Integer id);

  @Update("update tb_user set tb_user.address = #{address}  where id = #{id}")
  void updateUser(Integer id, String userName, String address);
}
