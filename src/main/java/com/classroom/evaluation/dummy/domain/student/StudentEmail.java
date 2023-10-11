package com.classroom.evaluation.dummy.domain.student;

import com.classroom.evaluation.shared.error.domain.Assert;
import com.classroom.evaluation.shared.error.domain.InvalidEmailException;
import java.util.regex.Pattern;

public record StudentEmail(String email) {
  private static final Pattern EMAIL_PATTERN = Pattern.compile("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$");

  public StudentEmail {
    Assert.field("email", email).notBlank().maxLength(255);
    if (!EMAIL_PATTERN.matcher(email).matches()) {
      throw new InvalidEmailException(email);
    }
  }

  public String get() {
    return email();
  }
}
