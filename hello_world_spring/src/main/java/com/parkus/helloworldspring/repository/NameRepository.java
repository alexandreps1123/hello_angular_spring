package com.parkus.helloworldspring.repository;

import com.parkus.helloworldspring.model.Name;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NameRepository extends JpaRepository<Name, Long>{

}
