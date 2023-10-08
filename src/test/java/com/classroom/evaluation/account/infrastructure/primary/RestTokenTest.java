package com.classroom.evaluation.account.infrastructure.primary;

import static com.classroom.evaluation.account.domain.TokensFixture.*;
import static org.assertj.core.api.Assertions.*;

import com.classroom.evaluation.JsonHelper;
import com.classroom.evaluation.UnitTest;
import org.junit.jupiter.api.Test;

@UnitTest
class RestTokenTest {

  @Test
  void shouldConvertFromDomain() {
    assertThat(JsonHelper.writeAsString(RestToken.from(token()))).isEqualTo(json());
  }

  private String json() {
    return "{\"id_token\":\"token\"}";
  }
}
