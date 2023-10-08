package com.classroom.evaluation.shared.kipe.application;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

import ch.qos.logback.classic.Level;
import com.classroom.evaluation.Logs;
import com.classroom.evaluation.LogsSpy;
import com.classroom.evaluation.LogsSpyExtension;
import com.classroom.evaluation.UnitTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.security.core.Authentication;

@UnitTest
@ExtendWith(LogsSpyExtension.class)
class ObjectAccessCheckerTest {

  private static final ObjectAccessChecker checker = new ObjectAccessChecker();

  @Logs
  private LogsSpy logs;

  @Test
  void shouldNotAuthorizeActionsOnNullElement() {
    assertThat(checker.can(new NullElementAccessContext<Object>(mock(Authentication.class), "dummy-action"))).isFalse();
    logs.shouldHave(Level.WARN, "dummy-action").shouldHave(Level.WARN, "access checker found").shouldHave(Level.WARN, "unknown");
  }

  @Test
  void shouldNotAuthorizeActionsOnElement() {
    assertThat(checker.can(new ElementAccessContext<Object>(mock(Authentication.class), "dummy-action", "element"))).isFalse();
    logs.shouldHave(Level.WARN, "dummy-action").shouldHave(Level.WARN, "access checker found").shouldHave(Level.WARN, "String");
  }
}
