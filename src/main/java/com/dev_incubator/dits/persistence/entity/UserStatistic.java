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
public class UserStatistic {

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

//create view user_statistic (id, user_id, test_id, amount, percent) as
//select row_number() over (ORDER BY u.id,q.test_id),
//       u.id,
//       q.test_id,
//       count(distinct s.date),
//       sum(s.correct) / count(q.test_id)*count(distinct s.date)*100
//from statistic s
//         left join user u on s.user_id = u.id
//         left join question q on s.question_id = q.id
//group by u.id, q.test_id;
