package com.classroom.evaluation.account.domain;

public final class TokensFixture {

  private TokensFixture() {}

  public static Token token() {
    return new Token("token");
  }
}