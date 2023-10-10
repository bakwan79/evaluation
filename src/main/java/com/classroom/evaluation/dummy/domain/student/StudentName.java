package com.classroom.evaluation.dummy.domain.student;

import com.classroom.evaluation.shared.error.domain.Assert;

public record StudentName(String name) {
  public StudentName {
    Assert.field("name", name).notBlank().maxLength(255);
  }

  public String get() {
    return name();
  }
}
