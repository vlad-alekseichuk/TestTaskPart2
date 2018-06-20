package com.test.part2.services;

import com.test.part2.persistence.model.Seat;

public interface SeatService {
    Seat findByRowNumberAndNumber(Integer rowNumber, Integer seatNumber);
}
