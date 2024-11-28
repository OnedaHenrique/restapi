package com.restapi.restapi.repository;

import org.springframework.data.repository.CrudRepository;

import com.restapi.restapi.model.User;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User,Long> {

    Optional<User> findByUsername(String username);

}