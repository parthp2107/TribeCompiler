package com.example.tribeCarrier.repository;

import com.example.tribeCarrier.entity.TribeCreateUserEntity;
import org.springframework.data.repository.CrudRepository;

public interface TribeRepository extends CrudRepository<TribeCreateUserEntity, Integer> {
TribeCreateUserEntity findByEmail(String email);
}
