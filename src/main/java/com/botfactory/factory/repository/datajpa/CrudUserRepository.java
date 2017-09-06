package com.botfactory.factory.repository.datajpa;

import com.botfactory.factory.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface CrudUserRepository extends JpaRepository<User, Integer> {

    @Override
    @Transactional
    User save(User user);
}
