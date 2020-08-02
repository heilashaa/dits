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
        value = "select t.id AS id, " +
                "t.id AS test_id, " +
                "count(DISTINCT  s.date) AS amountPass, " +
                "sum(s.correct) AS correct, " +
                "count(s.correct) AS total " +
                "FROM test t " +
                "RIGHT JOIN question q " +
                "ON t.id = q.test_id " +
                "RIGHT JOIN statistic s " +
                "ON q.id = s.question_id " +
                "GROUP BY t.name")
@Synchronize({"Statistic", "Test", "Question"})
public class TestStatistic {

    @Id
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;
    @OneToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "test_id", nullable = false)
    private Test test;
    private Integer amountPass;
    private Integer correct;
    private Integer total;
}
