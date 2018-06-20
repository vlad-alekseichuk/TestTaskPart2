package com.test.part2.services.impl;

import com.test.part2.dto.SearchDto;
import com.test.part2.persistence.model.Row;
import com.test.part2.persistence.model.Seat;
import com.test.part2.persistence.repository.RowRepository;
import com.test.part2.persistence.repository.SeatRepository;
import com.test.part2.services.RowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class RowServiceImpl implements RowService {

    @Autowired
    private RowRepository rowRepository;

    @Autowired
    private SeatRepository seatRepository;

    @Override
    public Row findByNumber(Integer number) {
        return rowRepository.findByNumber(number);
    }

    @Override
    public List<Row> findAll() {
        return rowRepository.findAll();
    }

    @Override
    public List<Row> getOrderedRows() {
        List<Row> rowList = rowRepository.findAll();
        for (Row row : rowList) {
            Set<Seat> sorted = row.getSeats()
                    .stream()
                    .sorted(Comparator.comparingInt(Seat::getNumber))
                    .collect(Collectors.toCollection(LinkedHashSet::new));
            row.setSeats(sorted);
        }
        Collections.sort(rowList, Comparator.comparingInt(Row::getNumber));

        return rowList;
    }

    @Override
    public List<Row> markAvailableSeats(Set<Seat> forBookingSeats) {
        List<Row> orderedRows = getOrderedRows();
        for (Row row : orderedRows) {
            for (Seat seat : row.getSeats()) {
                if (forBookingSeats.contains(seat)) {
                    seat.setForBooking(true);
                }
            }
        }
        return orderedRows;
    }

    @Override
    public List<Seat[]> search(SearchDto searchDto) {
        List<Seat[]> seats = new LinkedList<>();

        int rowNumber = searchDto.getRowNumber();
        int countPersons = searchDto.getNumberOfSeats();

        List<Seat> allSeatsInRow = findByNumber(rowNumber).getSeats()
                .stream()
                .sorted(Comparator.comparingInt(Seat::getNumber))
                .collect(Collectors.toCollection(ArrayList::new));

        for (int i = 0; i <= allSeatsInRow.size() - countPersons; i++) {
            List<Seat> order = new ArrayList<>();
            for (int j = 0; j < countPersons; j++) {
                if (allSeatsInRow.get(i + j).getAvailable()) {
                    order.add(allSeatsInRow.get(i + j));
                }
            }
            if (order.size() == countPersons) {
                seats.add(order.toArray(new Seat[order.size()]));
            }
        }


        return seats;
    }

    @Override
    public void bookSeats(Seat[] seatsToBook) {
        for (Seat seat : seatsToBook) {
            seat.setAvailable(false);
            seatRepository.save(seat);
        }
    }

    @Override
    public void redistributeAllSeats() {
//        List<Row> rowList = findAll();
//
//        for (Iterator<Row> iter = rowList.listIterator(); iter.hasNext(); ) {
//            Row row = iter.next();
//            Set<Seat> seats = row.getSeats();
//            for (Iterator<Seat> seatIter = seats.iterator(); iter.hasNext(); ) {
//                Seat seat = seatIter.next();
//                seat.setAvailable(Math.random() > 0.5);
//                seatRepository.save(seat);
//            }
//        }
        List<Seat> seats = seatRepository.findAll();
        for (Seat seat : seats) {
            seat.setAvailable(Math.random() > 0.5);
            seatRepository.save(seat);
        }
//        for (Row row : rowList) {
//            for (Seat seat : row.getSeats()) {
////                seat.setAvailable(Math.random() > 0.5);
//                seatRepository.save(seat);
//            }
//        }
    }
}
