package com.test.part2.services.impl;

import com.test.part2.persistence.model.Seat;
import com.test.part2.persistence.repository.SeatRepository;
import com.test.part2.services.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SeatServiceImpl implements SeatService {

    @Autowired
    private SeatRepository seatRepository;

    @Override
    public Seat findByRowNumberAndNumber(Integer rowNumber, Integer seatNumber) {
        return seatRepository.findByRowNumberAndNumber(rowNumber, seatNumber);
    }
}
