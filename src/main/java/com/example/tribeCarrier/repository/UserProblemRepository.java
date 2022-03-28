package com.example.tribeCarrier.repository;

import com.example.tribeCarrier.entity.UserProblemEntity;
import com.example.tribeCarrier.entity.UserProblemRef;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserProblemRepository extends CrudRepository<UserProblemEntity, Integer> {

  @Query(value = "insert into user_problem_reference (id ,problem_id, user_id) values(?1, ?2, ?3)" ,nativeQuery = true)
  UserProblemEntity insertToTable(int id ,int problem_id, int user_id);
}
