package ccc.springboot.coconut.service;

import ccc.springboot.coconut.dao.UserMapper;
import ccc.springboot.coconut.model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
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
    @CacheEvict(value="UserCache", key="'user.getAllUsers'")
    public void addUser(User user) {
        this.userMapper.addUser(user.getUsername(), user.getAddress());
    }

    @Override
    @Cacheable(value="UserCache", key="'user.getAllUsers'")     // how to define the key and value
    public List<User> getAllUsers() {
        return this.userMapper.getAllUsers();
    }

    @Override
    public User getUserById(Integer id) {
        Optional<User> opt = userMapper.getUserById(id);
        return  opt.orElse(null);
    }

    @Override
    @CacheEvict(value="UserCache", key="'user.getAllUsers'")
    public void updateUser(Integer id, User user) {
        Optional<User> opt = userMapper.getUserById(id);

        if (opt.isPresent()) {
            userMapper.updateUser(id, user.getUsername(), user.getAddress());
        }
    }

    @Override
    @CacheEvict(value="UserCache", key="'user.getAllUsers'")
    public void deleteUser(Integer id) {
    System.out.println("The user id: " + id + " has been deleted");
    this.userMapper.delete(id);
    }

}
