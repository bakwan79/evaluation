package com.classroom.evaluation.dummy.domain.student;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StudentDetailsTest {

  private StudentId studentId;
  private StudentName studentName;
  private StudentEmail studentEmail;
  private Student.StudentStatus studentStatus;
  private Student student;

  @BeforeEach
  void setUp() {
    studentId = StudentId.newId();
    studentName = new StudentName("John Doe");
    studentEmail = new StudentEmail("john.doe@example.com");
    studentStatus = Student.StudentStatus.ACTIVE; // Assuming an ACTIVE status for a new student
    student = Student.builder().id(studentId).name(studentName).email(studentEmail).status(studentStatus).build();
  }

  @Test
  void shouldCreateStudentWithValidDetails() {
    assertThat(student.id()).isEqualTo(studentId);
    assertThat(student.name()).isEqualTo(studentName);
    assertThat(student.email()).isEqualTo(studentEmail);
    assertThat(student.status()).isEqualTo(studentStatus);
  }

  @Test
  void shouldThrowExceptionWhenNameIsNull() {
    assertThatThrownBy(() -> new StudentName(null)).isInstanceOf(IllegalArgumentException.class).hasMessage("Name cannot be null");
  }

  @Test
  void shouldThrowExceptionWhenEmailIsInvalid() {
    assertThatThrownBy(() -> new StudentEmail("invalid-email")).isInstanceOf(IllegalArgumentException.class).hasMessage("Email is invalid");
  }
  // ... Add more tests as needed
}
