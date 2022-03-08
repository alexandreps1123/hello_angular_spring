package com.parkus.helloworldspring.service;

import java.util.List;
import java.util.Optional;

import com.parkus.helloworldspring.model.Names;
import com.parkus.helloworldspring.repository.NamesRepository;

import org.springframework.stereotype.Service;

@Service
public class NamesServiceImpl implements NamesService {

    private NamesRepository repository;

    public NamesServiceImpl(NamesRepository repository) {
        this.repository = repository;
    }

    @Override
    public Names save(Names name) {
        return repository.save(name);
    }

    @Override
    public Optional<Names> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Names> findAll() {
        return repository.findAll();
    }

}
