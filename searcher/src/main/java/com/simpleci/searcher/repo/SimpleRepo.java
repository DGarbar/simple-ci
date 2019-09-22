package com.simpleci.searcher.repo;

import com.simpleci.searcher.model.Student;
import org.springframework.data.repository.CrudRepository;

public interface SimpleRepo extends CrudRepository<Student, Long> {

}
