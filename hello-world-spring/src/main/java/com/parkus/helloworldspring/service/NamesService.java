package com.parkus.helloworldspring.service;

import java.util.List;
import java.util.Optional;

import com.parkus.helloworldspring.model.Names;

public interface NamesService {
    
    Names save(Names name);

    Optional<Names> findById(Long id);

    List<Names> findAll();

}
