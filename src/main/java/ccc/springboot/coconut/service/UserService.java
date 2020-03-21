package ccc.springboot.coconut.service;

import ccc.springboot.coconut.model.entity.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserService {
  // add an user
  void addUser(User user);
  // get all users
  List<User> getAllUsers();
  // delete user by id
  void deleteUser(Integer id);
}
