package com.test.part2.persistence.repository;

import com.test.part2.persistence.model.Row;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RowRepository extends JpaRepository<Row, Long> {
    Row findByNumber(Integer number);
}
