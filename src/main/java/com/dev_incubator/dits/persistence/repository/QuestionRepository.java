package com.dev_incubator.dits.persistence.repository;

import com.dev_incubator.dits.persistence.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long> {
}
