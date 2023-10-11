package com.classroom.evaluation.dummy.domain.student;

import com.classroom.evaluation.shared.error.domain.Assert;

public class StudentsUpdater {

  private final StudentsRepository students;

  public StudentsUpdater(StudentsRepository students) {
    Assert.notNull("students", students);

    this.students = students;
  }

  public Student update(StudentId id, StudentToUpdate studentToUpdate) {
    Assert.notNull("id", id);
    Assert.notNull("studentToUpdate", studentToUpdate);

    Student existingStudent = students.get(id).orElseThrow(() -> new UnknownStudentException(id));
    Student updatedStudent = studentToUpdate.update(existingStudent);

    students.save(updatedStudent);

    return updatedStudent;
  }
}
