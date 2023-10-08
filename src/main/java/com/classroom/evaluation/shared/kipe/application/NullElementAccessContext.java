package com.classroom.evaluation.shared.kipe.application;

import com.classroom.evaluation.shared.generation.domain.ExcludeFromGeneratedCodeCoverage;
import com.classroom.evaluation.shared.error.domain.Assert;
import org.springframework.security.core.Authentication;

@ExcludeFromGeneratedCodeCoverage(reason = "Untested null object structure")
record NullElementAccessContext<T>(Authentication authentication, String action) implements AccessContext<T> {
  public NullElementAccessContext {
    Assert.notNull("authentication", authentication);
    Assert.notBlank("action", action);
  }

  @Override
  public T element() {
    return null;
  }
}
