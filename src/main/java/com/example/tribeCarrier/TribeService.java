package com.example.tribeCarrier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TribeService {

  @Autowired
  TribeRepository tribeRepository;

  public List<TribeUserLogin> getLoggedInUser() {
    List<TribeUserLogin> tribeUserLogins = new ArrayList<TribeUserLogin>();
    tribeRepository.findAll().forEach(tribeUserLogins::add);
    return tribeUserLogins;
  }

  public TribeUserLogin getUserById(int id) {
    return tribeRepository.findById(id).get();
  }

  public void addUser(TribeUserLogin tribeUserLogin) {
    tribeRepository.save(tribeUserLogin);
  }
}
