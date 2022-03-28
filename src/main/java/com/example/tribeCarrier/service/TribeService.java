package com.example.tribeCarrier.service;

import com.example.tribeCarrier.entity.TribeCreateUserEntity;
import com.example.tribeCarrier.entity.TribeProblemsEntity;
import com.example.tribeCarrier.entity.UserProblemEntity;
import com.example.tribeCarrier.repository.TribeProblemRepository;
import com.example.tribeCarrier.repository.TribeRepository;
import com.example.tribeCarrier.repository.UserProblemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
public class TribeService {

  @Value("${upload.path}")
  private String uploadPath;

  @Autowired
  TribeRepository tribeRepository;
  @Autowired
  TribeProblemRepository tribeProblemRepository;
  @Autowired
  UserProblemRepository userProblemRepository;

  public List<Object> getAllUsersById() {
    return tribeRepository.getAllById();
  }

  public List<Object> getAllProblemId() {
    return tribeProblemRepository.getAllProblemId();
  }

  public TribeCreateUserEntity getUserByEmail(String email) {
    return tribeRepository.findByEmail(email);
  }

  public TribeProblemsEntity getProblemStatement(String category, String experience) {
    return tribeProblemRepository.getProblemStatement(category, experience);
  }

  public UserProblemEntity demo(int id, int problem_id, int user_id) {
    return userProblemRepository.insertToTable(id, problem_id, user_id);
  }

  public UserProblemEntity addUserProblemRef(UserProblemEntity userProblemEntity) {
    return userProblemRepository.save(userProblemEntity);
  }

  public TribeCreateUserEntity getUserById(int id) {
    return tribeRepository.findById(id).get();
  }

  public void addUser(TribeCreateUserEntity tribeCreateUserEntity) {
    tribeRepository.save(tribeCreateUserEntity);
  }

  public void addProblemStatement(TribeProblemsEntity tribeProblemsEntity) {
    tribeProblemRepository.save(tribeProblemsEntity);
  }

  public TribeProblemsEntity getUserByCategory(String category) {
    return tribeProblemRepository.findByCategory(category);
  }

  public TribeProblemsEntity getUserByExperience(String experience) {
    return tribeProblemRepository.findByExperience(experience);
  }

  @PostConstruct
  public void init() {
    try {
      Files.createDirectories(Paths.get(uploadPath));
    } catch (IOException e) {
      throw new RuntimeException("Could not create upload folder!");
    }
  }

  public void save(MultipartFile file) {
    try {
      Path root = Paths.get(uploadPath);
      if (!Files.exists(root)) {
        init();
      }
      Files.copy(file.getInputStream(), root.resolve(file.getOriginalFilename()));
    } catch (Exception e) {
      throw new RuntimeException("Could not store the file. Error: " + e.getMessage());
    }
  }

  public Resource load(String filename) {
    try {
      Path file = Paths.get(uploadPath)
              .resolve(filename);
      Resource resource = new UrlResource(file.toUri());

      if (resource.exists() || resource.isReadable()) {
        return resource;
      } else {
        throw new RuntimeException("Could not read the file!");
      }
    } catch (MalformedURLException e) {
      throw new RuntimeException("Error: " + e.getMessage());
    }
  }
}
