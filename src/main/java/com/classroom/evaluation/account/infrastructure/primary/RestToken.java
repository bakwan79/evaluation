package com.classroom.evaluation.account.infrastructure.primary;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.classroom.evaluation.account.domain.Token;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;

@Schema(name = "token", description = "A JWT token")
class RestToken {

  private String idToken;

  private RestToken(String idToken) {
    this.idToken = idToken;
  }

  static RestToken from(Token token) {
    return new RestToken(token.get());
  }

  @Schema(description = "JWT token", requiredMode = RequiredMode.REQUIRED)
  @JsonProperty("id_token")
  String getIdToken() {
    return idToken;
  }
}
