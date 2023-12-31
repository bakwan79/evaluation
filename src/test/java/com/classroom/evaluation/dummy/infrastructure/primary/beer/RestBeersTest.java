package com.classroom.evaluation.dummy.infrastructure.primary.beer;

import static org.assertj.core.api.Assertions.*;

import com.classroom.evaluation.JsonHelper;
import com.classroom.evaluation.UnitTest;
import com.classroom.evaluation.dummy.domain.beer.Beers;
import com.classroom.evaluation.dummy.domain.beer.BeersFixture;
import java.util.List;
import org.junit.jupiter.api.Test;

@UnitTest
class RestBeersTest {

  @Test
  void shouldSerializeToJson() {
    assertThat(JsonHelper.writeAsString(RestBeers.from(new Beers(List.of(BeersFixture.beer()))))).isEqualTo(json());
  }

  private String json() {
    return "{\"beers\":[" + RestBeerTest.json() + "]}";
  }
}
