package com.greenfox.exam.spring.repository;

import com.greenfox.exam.spring.model.QuestionAnswer;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface QuestionAnswerRepository extends CrudRepository<QuestionAnswer, Long>{

  public ArrayList<QuestionAnswer> findAllByOrderById();
}
