package com.greenfox.exam.spring.repository;

import com.greenfox.exam.spring.model.QuestionAnswer;
import org.springframework.data.repository.CrudRepository;

public interface QuestionAnswerRepository extends CrudRepository<QuestionAnswer, Long>{
}
