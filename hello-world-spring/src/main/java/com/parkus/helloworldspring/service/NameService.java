package com.parkus.helloworldspring.service;

import java.util.List;
import java.util.Optional;

import com.parkus.helloworldspring.model.Name;
import com.parkus.helloworldspring.repository.NameRepository;

import org.springframework.stereotype.Service;

@Service
public class NameService {

    private final NameRepository nameRepository;

    public NameService(NameRepository nameRepository) {
        this.nameRepository = nameRepository;
    }

    public void saveName(Name name) {
        nameRepository.save(name);
    }

    public List<Name> getAllNames() {
        return nameRepository.findAll();
    }

    public Optional<Name> getToUpperName(Long id) {

        Optional<Name> optionalName = nameRepository.findById(id);

        if (optionalName.isEmpty()) {
            throw new IllegalAccessError("Does not exists " + id + " saved.");
        }

        Name name = optionalName.get();

        name.setFullName(name.getFullName().toUpperCase());

        optionalName = Optional.of(name);

        return optionalName;
    }

}
