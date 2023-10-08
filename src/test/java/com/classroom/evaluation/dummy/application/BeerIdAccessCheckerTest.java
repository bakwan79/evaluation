package com.classroom.evaluation.dummy.application;

import static com.classroom.evaluation.dummy.domain.BeersIdentityFixture.*;
import static com.classroom.evaluation.shared.kipe.application.TestAuthentications.*;
import static org.assertj.core.api.Assertions.*;

import com.classroom.evaluation.UnitTest;
import com.classroom.evaluation.shared.kipe.application.AccessContext;
import com.classroom.evaluation.shared.kipe.application.EvaluationAuthorizations;
import java.util.List;
import org.junit.jupiter.api.Test;

@UnitTest
class BeerIdAccessCheckerTest {

  private static final BeerIdAccessChecker checker = new BeerIdAccessChecker(
    new EvaluationAuthorizations(List.of(new BeersAccessesConfiguration().beersAccesses()))
  );

  @Test
  void shouldNotAuthorizedUnauthorizedAction() {
    assertThat(checker.can(AccessContext.of(admin(), "unauthorized", cloackOfFeathersId()))).isFalse();
  }

  @Test
  void shouldAuthorizedAuthorizedAction() {
    assertThat(checker.can(AccessContext.of(admin(), "create", cloackOfFeathersId()))).isTrue();
  }
}
