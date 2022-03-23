package com.example.tribeCarrier.service;

import com.example.tribeCarrier.entity.TribeCheckUserEntity;
import com.example.tribeCarrier.entity.TribeCreateUserEntity;
import com.example.tribeCarrier.entity.TribeUserLoginEntity;
import com.example.tribeCarrier.repository.TribeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TribeService {

  @Autowired
  TribeRepository tribeRepository;

  public List<TribeCreateUserEntity> getLoggedInUser() {
    return new ArrayList<TribeCreateUserEntity>(tribeRepository.findAll());
  }

  public TribeCreateUserEntity getUserByEmail(String email) {
    return tribeRepository.findByEmail(email);
  }

  public TribeCreateUserEntity getUserById(int id) {
    return tribeRepository.findById(id).get();
  }

  public void addUser(TribeCreateUserEntity tribeUserLogin) {
    tribeRepository.save(tribeUserLogin);
  }
}
