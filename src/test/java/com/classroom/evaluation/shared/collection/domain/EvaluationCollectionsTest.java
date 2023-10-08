package com.classroom.evaluation.shared.collection.domain;

import static org.assertj.core.api.Assertions.*;

import com.classroom.evaluation.UnitTest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@UnitTest
class EvaluationCollectionsTest {

  @Nested
  @DisplayName("Collections")
  class EvaluationCollectionsCollectionsTest {

    @Test
    void shouldGetEmptyImmutableCollectionFromNullCollection() {
      Collection<Object> input = null;
      Collection<Object> collection = EvaluationCollections.immutable(input);

      assertThat(collection).isEmpty();
      assertThatThrownBy(collection::clear).isExactlyInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void shouldGetImmutableCollectionFromMutableCollection() {
      Collection<String> input = new ArrayList<>();
      input.add("value");
      Collection<String> collection = EvaluationCollections.immutable(input);

      assertThat(collection).containsExactly("value");
      assertThatThrownBy(collection::clear).isExactlyInstanceOf(UnsupportedOperationException.class);
    }
  }

  @Nested
  @DisplayName("Set")
  class EvaluationCollectionsSetTest {

    @Test
    void shouldGetEmptyImmutableCollectionFromNullCollection() {
      Set<Object> input = null;
      Set<Object> set = EvaluationCollections.immutable(input);

      assertThat(set).isEmpty();
      assertThatThrownBy(set::clear).isExactlyInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void shouldGetImmutableCollectionFromMutableCollection() {
      Set<String> input = new HashSet<>();
      input.add("value");
      Set<String> set = EvaluationCollections.immutable(input);

      assertThat(set).containsExactly("value");
      assertThatThrownBy(set::clear).isExactlyInstanceOf(UnsupportedOperationException.class);
    }
  }

  @Nested
  @DisplayName("List")
  class EvaluationCollectionsListTest {

    @Test
    void shouldGetEmptyImmutableCollectionFromNullCollection() {
      List<Object> input = null;
      List<Object> list = EvaluationCollections.immutable(input);

      assertThat(list).isEmpty();
      assertThatThrownBy(list::clear).isExactlyInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void shouldGetImmutableCollectionFromMutableCollection() {
      List<String> input = new ArrayList<>();
      input.add("value");
      List<String> list = EvaluationCollections.immutable(input);

      assertThat(list).containsExactly("value");
      assertThatThrownBy(list::clear).isExactlyInstanceOf(UnsupportedOperationException.class);
    }
  }

  @Nested
  @DisplayName("Map")
  class EvaluationMapTest {

    @Test
    void shouldGetEmptyImmutableMapFromNullMap() {
      Map<Object, Object> input = null;
      Map<Object, Object> map = EvaluationCollections.immutable(input);

      assertThat(map).isEmpty();
      assertThatThrownBy(map::clear).isExactlyInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void shouldGetImmutableMapFromMutableMap() {
      Map<String, String> input = new HashMap<>();
      input.put("key", "value");
      Map<String, String> map = EvaluationCollections.immutable(input);

      assertThat(map).containsExactly(Map.entry("key", "value"));
      assertThatThrownBy(map::clear).isExactlyInstanceOf(UnsupportedOperationException.class);
    }
  }
}
