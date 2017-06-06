package com.greenfox.exam.spring.model;

import com.greenfox.exam.spring.repository.ProjectRepository;

import javax.persistence.*;

@Entity
public class ProjectToDecode {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  private String nameOfProject;

  public ProjectToDecode() {}

  public ProjectToDecode(String nameOfProject) {
    this.nameOfProject = nameOfProject;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getNameOfProject() {
    return nameOfProject;
  }

  public void setNameOfProject(String nameOfProject) {
    this.nameOfProject = nameOfProject;
  }
}
