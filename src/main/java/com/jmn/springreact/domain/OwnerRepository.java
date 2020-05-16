package com.jmn.springreact.domain;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OwnerRepository extends CrudRepository <Owner, Long> {
    List <Owner> findByOwnerId(Long id);

    List <Owner> findByName(String name);
}
