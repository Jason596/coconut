package ccc.springboot.coconut.service;

import ccc.springboot.coconut.dao.UserMapper;
import ccc.springboot.coconut.model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getAllUsers() {
        return this.userMapper.getAllUsers();
    }

    @Override
    public void deleteUser(Integer id) {
    System.out.println("The user id: " + id + " has been deleted");
    this.userMapper.delete(id);
    }

}
