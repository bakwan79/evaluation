package com.classroom.evaluation.dummy.infrastructure.secondary;

import static org.assertj.core.api.Assertions.*;
import static com.classroom.evaluation.dummy.domain.beer.BeersFixture.*;

import org.junit.jupiter.api.Test;
import com.classroom.evaluation.UnitTest;

@UnitTest
class BeerEntityTest {

  @Test
  void shouldConvertFromAndToDomain() {
    assertThat(BeerEntity.from(beer()).toDomain()).usingRecursiveComparison().isEqualTo(beer());
  }
}
