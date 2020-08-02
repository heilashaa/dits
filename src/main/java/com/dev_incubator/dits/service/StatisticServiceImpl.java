package com.dev_incubator.dits.service;

import com.dev_incubator.dits.persistence.entity.QuestionStatistic;
import com.dev_incubator.dits.persistence.entity.TestStatistic;
import com.dev_incubator.dits.persistence.repository.QuestionStatisticRepository;
import com.dev_incubator.dits.persistence.repository.TestStatisticRepository;
import com.dev_incubator.dits.service.interfaces.StatisticService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional

public class StatisticServiceImpl implements StatisticService {

    private final TestStatisticRepository testStatisticRepository;

    private final QuestionStatisticRepository questionStatisticRepository;

    public StatisticServiceImpl(TestStatisticRepository testStatisticRepository, QuestionStatisticRepository questionStatisticRepository) {
        this.testStatisticRepository = testStatisticRepository;
        this.questionStatisticRepository = questionStatisticRepository;
    }

    @Override
    public List<TestStatistic> getStatisticByTests(){
        return testStatisticRepository.findAll();
    }

    @Override
    public List<QuestionStatistic> getStatisticByQuestions(){
        return questionStatisticRepository.findAll();
    }
}
