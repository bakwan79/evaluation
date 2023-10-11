package com.classroom.evaluation.dummy.domain.student;

class UnknownStudentException extends RuntimeException {

  public UnknownStudentException(StudentId id) {
    super("Student " + id.get() + " is unknown");
  }
}
