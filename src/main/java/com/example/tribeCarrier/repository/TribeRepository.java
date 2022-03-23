package com.example.tribeCarrier.repository;

import com.example.tribeCarrier.entity.TribeCheckUserEntity;
import com.example.tribeCarrier.entity.TribeCreateUserEntity;
import com.example.tribeCarrier.entity.TribeUserLoginEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TribeRepository extends JpaRepository<TribeCreateUserEntity, Integer> {
//  TribeCreateUserEntity findByEmail(String email);
TribeCreateUserEntity findByEmail(String email);
//  TribeUserLoginEntity findByLoggedInEmail(String email);
}
