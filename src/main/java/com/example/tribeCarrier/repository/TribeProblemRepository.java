package com.example.tribeCarrier.repository;

import com.example.tribeCarrier.entity.TribeProblemsEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface TribeProblemRepository extends CrudRepository<TribeProblemsEntity, Integer> {
  TribeProblemsEntity findByCategory(String category);
  TribeProblemsEntity findByExperience(String experience);

  @Query(value = "select * from tribe_problem where category=?1 and experience=?2", nativeQuery = true)
  public TribeProblemsEntity getProblemStatement(String category, String experience);
}
