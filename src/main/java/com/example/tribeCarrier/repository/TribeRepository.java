package com.example.tribeCarrier.repository;

import com.example.tribeCarrier.entity.TribeCreateUserEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TribeRepository extends CrudRepository<TribeCreateUserEntity, Integer> {
  TribeCreateUserEntity findByEmail(String email);

  @Query(value = "select id, name from TRIBE_COMPILER", nativeQuery = true)
  List<Object> getAllById();
}
