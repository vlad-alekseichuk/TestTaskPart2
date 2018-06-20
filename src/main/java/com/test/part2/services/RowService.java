package com.test.part2.services;

import com.test.part2.dto.SearchDto;
import com.test.part2.persistence.model.Row;
import com.test.part2.persistence.model.Seat;

import java.util.List;
import java.util.Set;

public interface RowService {

    Row findByNumber(Integer number);

    List<Row> findAll();

    List<Row> getOrderedRows();

    List<Row> markAvailableSeats(Set<Seat> forBookingSeats);

    List<Seat[]> search(SearchDto searchDto);

    void bookSeats(Seat[] seatsToBook);

    void redistributeAllSeats();
}
