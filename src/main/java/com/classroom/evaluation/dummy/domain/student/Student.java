package com.classroom.evaluation.dummy.domain.student;

import com.classroom.evaluation.dummy.domain.beer.BeerSellingState;
import com.classroom.evaluation.shared.error.domain.Assert;

public class Student {

  public enum StudentStatus {
    ACTIVE,
    INACTIVE,
  }

  private final com.classroom.evaluation.dummy.domain.student.StudentId id;
  private final StudentName name;
  private final StudentEmail email;
  private StudentStatus status;

  private Student(StudentBuilder builder) {
    assertMandatoryFields(builder);

    id = builder.id;
    name = builder.name;
    email = builder.email;
    status = builder.status;
  }

  private void assertMandatoryFields(StudentBuilder builder) {
    Assert.notNull("id", builder.id);
    Assert.notNull("name", builder.name);
    Assert.notNull("email", builder.email);
    Assert.notNull("status", builder.status);
  }

  public static StudentIdBuilder builder() {
    return new StudentBuilder();
  }

  public com.classroom.evaluation.dummy.domain.student.StudentId id() {
    return id;
  }

  public StudentName name() {
    return name;
  }

  public StudentEmail email() {
    return email;
  }

  public StudentStatus status() {
    return status;
  }

  public void setInactive() {
    status = StudentStatus.INACTIVE;
  }

  public static class StudentBuilder
    implements StudentIdBuilder, StudentNameBuilder, StudentEmailBuilder, StudentStatusBuilder, StudentOptionalBuilder {

    private com.classroom.evaluation.dummy.domain.student.StudentId id;
    private StudentName name;
    private StudentEmail email;
    private StudentStatus status;

    @Override
    public StudentNameBuilder id(com.classroom.evaluation.dummy.domain.student.StudentId id) {
      this.id = id;
      return this;
    }

    @Override
    public StudentEmailBuilder name(StudentName name) {
      this.name = name;
      return this;
    }

    @Override
    public StudentStatusBuilder email(StudentEmail email) {
      this.email = email;
      return this;
    }

    @Override
    public StudentOptionalBuilder status(StudentStatus status) {
      this.status = status;
      return this;
    }

    @Override
    public Student build() {
      return new Student(this);
    }
  }

  public interface StudentIdBuilder {
    StudentNameBuilder id(com.classroom.evaluation.dummy.domain.student.StudentId id);
  }

  public interface StudentNameBuilder {
    StudentEmailBuilder name(StudentName name);
  }

  public interface StudentEmailBuilder {
    StudentStatusBuilder email(StudentEmail email);
  }

  public interface StudentStatusBuilder {
    StudentOptionalBuilder status(StudentStatus status);
  }

  public interface StudentOptionalBuilder {
    Student build();
  }
}
