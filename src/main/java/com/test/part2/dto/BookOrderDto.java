package com.test.part2.dto;

import com.test.part2.persistence.model.Seat;

public class BookOrderDto {
    private Seat[] seatsToBook;

    public Seat[] getSeatsToBook() {
        return seatsToBook;
    }

    public void setSeatsToBook(Seat[] seatsToBook) {
        this.seatsToBook = seatsToBook;
    }
}
