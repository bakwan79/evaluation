package com.classroom.evaluation.dummy.domain.student;

import com.classroom.evaluation.shared.error.domain.Assert;

public class StudentsCreator {

  private final StudentsRepository students;

  public StudentsCreator(StudentsRepository students) {
    Assert.notNull("students", students);

    this.students = students;
  }

  public Student create(StudentToCreate studentToCreate) {
    Student createdStudent = studentToCreate.create();

    students.save(createdStudent);

    return createdStudent;
  }
}
