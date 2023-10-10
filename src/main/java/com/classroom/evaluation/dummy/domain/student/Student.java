package com.classroom.evaluation.dummy.domain.student;

import com.classroom.evaluation.shared.error.domain.Assert;

public class Student {

  private final com.classroom.evaluation.dummy.domain.student.StudentId id;
  private final StudentName name;
  private final StudentEmail email;

  // ... any other attributes you'd like to include

  private Student(StudentBuilder builder) {
    assertMandatoryFields(builder);

    id = builder.id;
    name = builder.name;
    email = builder.email;
    // ... initialize other attributes
  }

  private void assertMandatoryFields(StudentBuilder builder) {
    Assert.notNull("id", builder.id);
    Assert.notNull("name", builder.name);
    Assert.notNull("email", builder.email);
    // ... assert other attributes
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

  // ... getters for other attributes

  public static class StudentBuilder implements StudentIdBuilder, StudentNameBuilder, StudentEmailBuilder, StudentOptionalBuilder {

    private com.classroom.evaluation.dummy.domain.student.StudentId id;
    private StudentName name;
    private StudentEmail email;

    // ... other attributes

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
    public StudentOptionalBuilder email(StudentEmail email) {
      this.email = email;
      return this;
    }

    // ... setters for other attributes

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
    StudentOptionalBuilder email(StudentEmail email);
  }

  public interface StudentOptionalBuilder {
    Student build();
  }
}
