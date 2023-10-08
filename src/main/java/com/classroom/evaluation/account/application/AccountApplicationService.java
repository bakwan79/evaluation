package com.classroom.evaluation.account.application;

import com.classroom.evaluation.account.domain.AuthenticationQuery;
import com.classroom.evaluation.account.domain.Token;
import com.classroom.evaluation.account.domain.TokensRepository;
import org.springframework.stereotype.Service;

@Service
public class AccountApplicationService {

  private final TokensRepository tokens;

  public AccountApplicationService(TokensRepository tokens) {
    this.tokens = tokens;
  }

  public Token createToken(AuthenticationQuery query) {
    return tokens.buildToken(query);
  }
}
