package com.dev_incubator.dits.service.interfaces;

import com.dev_incubator.dits.persistence.entity.QuestionStatistic;
import com.dev_incubator.dits.persistence.entity.TestStatistic;

import java.util.List;

public interface StatisticService {

    List<TestStatistic> getStatisticByTests();

    List<QuestionStatistic> getStatisticByQuestions();
}
