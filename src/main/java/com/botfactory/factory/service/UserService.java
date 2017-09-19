package com.botfactory.factory.service;

import com.botfactory.factory.model.User;
import com.botfactory.factory.util.exception.NotFoundException;

import java.util.List;

public interface UserService {

    User create(User user);

    void delete(int id) throws NotFoundException;

    User get(int id) throws NotFoundException;

    User getByEmail(String email) throws NotFoundException;

    void update(User user);

    void evictCache();

    List<User> getAll();

    User getWithBots(int id);

}
