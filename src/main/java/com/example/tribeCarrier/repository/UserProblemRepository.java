package com.example.tribeCarrier.repository;

import com.example.tribeCarrier.entity.UserProblemProjection;
import com.example.tribeCarrier.entity.UserProblemEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface UserProblemRepository extends CrudRepository<UserProblemEntity, Integer> {

  @Query(value = "select u.id as userId, u.name as name, u.email as email, u.user_experience as userExperience, p.problem_id as problemId, p.problem_name as problemName, p.category as category, p.problem_experience as problemExperience, p.problem_time as problemTime from TRIBE_COMPILER as u left join user_problem_reference as r on u.id=r.user_id left join tribe_problem as p on r.problem_id=p.problem_id where r.user_id=?1", nativeQuery = true)
  List<UserProblemProjection> getUserProblemDetails(int user_id);
}
