package com.classroom.evaluation.shared.kipe.domain;

import static org.assertj.core.api.Assertions.*;

import com.classroom.evaluation.UnitTest;
import org.junit.jupiter.api.Test;

@UnitTest
class ActionTest {

  @Test
  void shouldGetActionAsToString() {
    assertThat(new Action("act")).hasToString("act");
  }
}
