package com.dev_incubator.dits.persistence.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;
import org.hibernate.annotations.Synchronize;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Immutable
@Subselect(
        value = "select q.id AS id, " +
                "q.id AS question_id, " +
                "count(DISTINCT  s.date) AS amountPass, " +
                "sum(s.correct) AS correct, " +
                "count(s.correct) AS total " +
                "FROM question q " +
                "RIGHT JOIN statistic s " +
                "ON q.id = s.question_id " +
                "GROUP BY q.id")
@Synchronize({"Statistic", "Question"})
public class QuestionStatistic {

    @Id
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;
    @OneToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "question_id", nullable = false)
    private Question question;
    private Integer amountPass;
    private Integer correct;
    private Integer total;
}
