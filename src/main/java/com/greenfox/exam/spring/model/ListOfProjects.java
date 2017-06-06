package com.greenfox.exam.spring.model;

import java.util.ArrayList;
import java.util.List;

public class ListOfProjects {
  private List<ProjectToDecode> projectList = new ArrayList<>();

  public ListOfProjects() {}

  public ListOfProjects(List<ProjectToDecode> projects) {
    this.projectList = projects;
  }

  public List<ProjectToDecode> getProjectList() {
    return projectList;
  }

  public void setProjectList(List<ProjectToDecode> projectList) {
    this.projectList = projectList;
  }

}
