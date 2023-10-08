package com.classroom.evaluation.account.domain;

public interface TokensRepository {
  Token buildToken(AuthenticationQuery query);
}
