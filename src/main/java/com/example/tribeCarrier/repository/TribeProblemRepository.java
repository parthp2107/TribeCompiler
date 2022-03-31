package com.example.tribeCarrier.repository;

import com.example.tribeCarrier.entity.TribeProblemsEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TribeProblemRepository extends CrudRepository<TribeProblemsEntity, Integer> {
  TribeProblemsEntity findByProblemId(int id);

  @Query(value = "select * from tribe_problem where category=?1 and problem_experience=?2", nativeQuery = true)
  public TribeProblemsEntity getProblemStatement(String category, String problem_experience);

  @Query(value = "select problem_id, problem_name from tribe_problem", nativeQuery = true)
    List<Object> getAllProblemId();
}
