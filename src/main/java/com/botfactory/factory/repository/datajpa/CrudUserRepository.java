package com.botfactory.factory.repository.datajpa;

import com.botfactory.factory.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CrudUserRepository extends CrudRepository<User, Integer> {

}
