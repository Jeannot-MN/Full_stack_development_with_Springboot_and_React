package com.jmn.springreact.repository;

import com.jmn.springreact.domain.Owner;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OwnerRepository extends CrudRepository <Owner, Long> {
    List <Owner> findByOwnerId(Long id);

    List <Owner> findByName(String name);
}
