package com.test.part2.persistence.model;

import javax.persistence.*;

@Entity
@Table(name = "seat")
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Integer number;

    private Boolean available;

    @Transient
    private boolean forBooking;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "row_id")
    private Row row;

    public Seat() {
    }

    public Seat(Integer number, Boolean available) {
        this.number = number;
        this.available = available;
    }

    public Seat(Integer number, Boolean available, Row row) {
        this.number = number;
        this.available = available;
        this.row = row;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public Row getRow() {
        return row;
    }

    public void setRow(Row row) {
        this.row = row;
    }

    public boolean isForBooking() {
        return forBooking;
    }

    public void setForBooking(boolean forBooking) {
        this.forBooking = forBooking;
    }
}
