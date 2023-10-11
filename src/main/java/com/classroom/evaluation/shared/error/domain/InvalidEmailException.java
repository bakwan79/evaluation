package com.classroom.evaluation.shared.error.domain;

public class InvalidEmailException extends RuntimeException {

  public InvalidEmailException(String email) {
    super("Invalid email format: " + email);
  }
}
