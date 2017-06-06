package com.greenfox.exam.spring.repository;

import com.greenfox.exam.spring.model.QuestionAnswer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;

@Repository
public interface QuestionAnswerRepository extends CrudRepository<QuestionAnswer, Long>{
  public ArrayList<QuestionAnswer> findAllByOrderById();
}
