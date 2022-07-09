package com.parkus.helloworldspring.controller;

import java.util.List;
import java.util.Optional;

import com.parkus.helloworldspring.model.Name;
import com.parkus.helloworldspring.service.NameService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/name")
public class NameController {

  private final NameService namesService;

  public NameController(NameService namesService) {
    this.namesService = namesService;
  }

  @GetMapping
  public List<Name> getNames() {
    return namesService.getAllNames();
  }

  @GetMapping(path = "/{id}")
  public Optional<Name> getUpperName(@PathVariable("id") Long id) {
    return namesService.getToUpperName(id);
  }

  @PostMapping
  public void registerNewName(@RequestBody Name name) {
    namesService.saveName(name);
  }
}
