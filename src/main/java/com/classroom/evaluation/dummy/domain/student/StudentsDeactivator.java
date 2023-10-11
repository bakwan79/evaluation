package com.classroom.evaluation.dummy.domain.student;

import com.classroom.evaluation.shared.error.domain.Assert;

public class StudentsDeactivator {

  private final StudentsRepository students;

  public StudentsDeactivator(StudentsRepository students) {
    Assert.notNull("students", students);
    this.students = students;
  }

  public void deactivate(StudentId id) {
    Assert.notNull("id", id);
    Student student = students.get(id).orElseThrow(() -> new UnknownStudentException(id));
    student.setInactive();
    students.save(student);
  }
}
