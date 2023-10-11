package com.classroom.evaluation.dummy.domain.student;

import java.util.Optional;

public interface StudentsRepository {
  void save(Student student);

  Students catalog();

  Optional<Student> get(StudentId id);
}
