package com.classroom.evaluation.dummy.domain.student;

import com.classroom.evaluation.shared.error.domain.Assert;
import java.util.Collection;
import java.util.Comparator;
import java.util.stream.Stream;

public record Students(Collection<Student> students) {
  private static final Comparator<Student> STUDENT_NAME_COMPARATOR = Comparator.comparing(student -> student.name().get());

  public Students(Collection<Student> students) {
    Assert.field("students", students).notNull().noNullElement();

    this.students = students.stream().sorted(STUDENT_NAME_COMPARATOR).toList();
  }

  public Collection<Student> get() {
    return students();
  }

  public Stream<Student> stream() {
    return students().stream();
  }
}
