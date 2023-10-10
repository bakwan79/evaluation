package com.classroom.evaluation.dummy.domain.student;

import com.classroom.evaluation.shared.error.domain.Assert;
import java.util.UUID;

public record StudentId(UUID id) {
  public StudentId {
    Assert.notNull("id", id);
  }

  public static StudentId newId() {
    return new StudentId(UUID.randomUUID());
  }

  public UUID get() {
    return id();
  }
}
