package com.botfactory.factory.repository;

import com.botfactory.factory.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("userRepository")
public class UserRepositoryImpl implements UserRepository {

//    @Autowired
//    private CrudUserRepository crudUserRepository;

    @Override
    public User save(User user) {
        return null;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public User get(int id) {
        return null;
    }

    @Override
    public User getByEmail(String email) {
        return null;
    }

    @Override
    public List<User> getAll() {
        return null;
    }
}
