package com.classroom.evaluation.shared.pagination.domain;

import java.util.List;

import com.classroom.evaluation.shared.pagination.domain.EvaluationPage.EvaluationPageBuilder;

public final class EvaluationPagesFixture {

  private EvaluationPagesFixture() {}

  public static EvaluationPage<String> page() {
    return pageBuilder().build();
  }

  public static EvaluationPageBuilder<String> pageBuilder() {
    return EvaluationPage.builder(List.of("test")).currentPage(2).pageSize(10).totalElementsCount(21);
  }
}
