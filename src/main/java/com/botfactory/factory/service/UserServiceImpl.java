package com.botfactory.factory.service;

import com.botfactory.factory.model.User;
import com.botfactory.factory.repository.UserRepository;
import com.botfactory.factory.util.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    @Qualifier("userRepository")
    private UserRepository repository;


    @Override
    public User create(User user) {
        Assert.notNull(user,"user can't be null");
        return repository.save(user);
    }

    @Override
    public void delete(int id) throws NotFoundException {
        repository.delete(id);
    }

    @Override
    public User get(int id) throws NotFoundException {
        return repository.get(id);
    }

    @Override
    public User getByEmail(String email) throws NotFoundException {
        return repository.getByEmail(email);
    }

    @Override
    public void update(User user) {
        Assert.notNull(user,"user can't be null");
        repository.save(user);
    }

    @Override
    public void evictCache() {

    }

    @Override
    public List<User> getAll() {
        return repository.getAll();
    }

    @Override
    public User getWithBots(int id) {
        return null;
    }
}
