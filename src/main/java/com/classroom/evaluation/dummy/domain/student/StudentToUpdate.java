package com.classroom.evaluation.dummy.domain.student;

public record StudentToUpdate(StudentName name, StudentEmail email, Student.StudentStatus status) {
  public Student update(Student existingStudent) {
    return Student
      .builder()
      .id(existingStudent.id())
      .name(this.name() != null ? this.name() : existingStudent.name())
      .email(this.email() != null ? this.email() : existingStudent.email())
      .status(this.status() != null ? this.status() : existingStudent.status())
      .build();
  }
}
