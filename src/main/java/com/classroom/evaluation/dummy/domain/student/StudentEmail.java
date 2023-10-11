package com.classroom.evaluation.dummy.domain.student;

import com.classroom.evaluation.shared.error.domain.Assert;

public record StudentEmail(String email) {
  public StudentEmail {
    Assert.field("email", email).notBlank().maxLength(255);
  }

  public String get() {
    return email();
  }
}
