package com.example.tribeCarrier.repository;

import com.example.tribeCarrier.entity.UserProblemEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface UserProblemRepository extends CrudRepository<UserProblemEntity, Integer> {

  @Query(value = "select u.id, u.name, u.email, u.user_experience, p.problem_id, p.problem_name, p.category, p.problem_experience, p.problem_time from TRIBE_COMPILER as u left join user_problem_reference as r on u.id=r.user_id left join tribe_problem as p on r.problem_id=p.problem_id where r.user_id=?1", nativeQuery = true)
  List<Object> getUserProblemDetails(int user_id);
}
