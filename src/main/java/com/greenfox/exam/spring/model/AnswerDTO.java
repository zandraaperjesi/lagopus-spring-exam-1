package com.greenfox.exam.spring.model;

import java.util.ArrayList;
import java.util.List;

public class AnswerDTO {
  private long id;
  private List<Answer> answers= new ArrayList<> ();

  public AnswerDTO() {}

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public List<Answer> getAnswers() {
    return answers;
  }

  public void setAnswers(List<Answer> answers) {
    this.answers = answers;
  }
}
