package com.parkus.helloworldspring.controller;

import java.util.List;
import java.util.Optional;

import com.parkus.helloworldspring.model.Names;
import com.parkus.helloworldspring.service.NamesService;
import com.parkus.helloworldspring.utils.NamesUtils;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/api/names")
public class NamesController {

  private final NamesService namesService;

  public NamesController(NamesService namesService) {
    this.namesService = namesService;
  }

  @GetMapping
  public ResponseEntity<List<Names>> listAllNames() {

    if (namesService.findAll().isEmpty()) {
      return ResponseEntity.notFound().build();
    }

    return ResponseEntity.ok(namesService.findAll());
  }

  @GetMapping(path = "/{id}")
  public ResponseEntity<Optional<Names>> getUpperName(@PathVariable("id") Long id) {

    if (namesService.findById(id).isEmpty()) {
      return ResponseEntity.notFound().build();
    }

    return ResponseEntity.ok(NamesUtils.toUpperName(namesService.findById(id)));
  }

  @PostMapping
  @ResponseBody
  public ResponseEntity<Object> createName(@RequestBody Names name) {

    Names namesCreated = namesService.save(name);

    var uri = ServletUriComponentsBuilder.fromCurrentRequest().path("").build().toUri();

    return ResponseEntity.created(uri).body(namesCreated);

  }

}
