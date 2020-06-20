package com.jmn.springreact.repository;

import com.jmn.springreact.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.net.UnknownServiceException;

public interface UserRepository extends CrudRepository <User, Long> {
    User findByUsername(String username);
}
