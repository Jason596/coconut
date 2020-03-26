package ccc.springboot.coconut.service;

import ccc.springboot.coconut.model.entity.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface UserService {

  // add an user
  void addUser(User user);

  // get all users
  List<User> getAllUsers();

  // get user by id
  User getUserById(Integer id);

  // delete user by id
  void deleteUser(Integer id);
}
