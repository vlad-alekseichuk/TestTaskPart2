package com.test.part2.persistence.repository;

import com.test.part2.persistence.model.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatRepository extends JpaRepository<Seat, Long> {
    Seat findByRowNumberAndNumber(Integer rowNumber, Integer seatNumber);

}
