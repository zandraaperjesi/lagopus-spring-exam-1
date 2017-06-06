package com.greenfox.exam.spring.repository;

import com.greenfox.exam.spring.model.ProjectToDecode;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProjectRepository extends CrudRepository<ProjectToDecode, Long>{
  public List<ProjectToDecode> findAllByOrderById();
}
