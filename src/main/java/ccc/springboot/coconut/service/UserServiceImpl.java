package ccc.springboot.coconut.service;

import ccc.springboot.coconut.dao.UserMapper;
import ccc.springboot.coconut.model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {


    private UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public void addUser(User user) {
        this.userMapper.addUser(user.getUsername(), user.getAddress());
    }

    @Override
    public List<User> getAllUsers() {
        return this.userMapper.getAllUsers();
    }

    @Override
    public Optional<User> getUserById(Integer id) {
        return userMapper.getUserById(id);
    }

    @Override
    public void deleteUser(Integer id) {
    System.out.println("The user id: " + id + " has been deleted");
    this.userMapper.delete(id);
    }

}
