package com.greenfox.exam.spring.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class QuestionAnswer {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  private String question;
  private String answer;

  public QuestionAnswer() {}

  public QuestionAnswer(String question, String answer) {
    this.question = question;
    this.answer = answer;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getQuestion() {
    return question;
  }

  public void setQuestion(String question) {
    this.question = question;
  }

  public String getAnswer() {
    return answer;
  }

  public void setAnswer(String answer) {
    this.answer = answer;
  }
}
