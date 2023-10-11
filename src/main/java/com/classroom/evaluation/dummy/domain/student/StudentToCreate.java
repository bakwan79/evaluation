package com.classroom.evaluation.dummy.domain.student;

import com.classroom.evaluation.shared.error.domain.Assert;

public record StudentToCreate(StudentName name, StudentEmail email) {
  public StudentToCreate {
    Assert.notNull("name", name);
    Assert.notNull("email", email);
  }

  public Student create() {
    return Student
      .builder()
      .id(StudentId.newId())
      .name(name())
      .email(email())
      .status(Student.StudentStatus.ACTIVE) // Set default status to ACTIVE
      .build();
  }
}
