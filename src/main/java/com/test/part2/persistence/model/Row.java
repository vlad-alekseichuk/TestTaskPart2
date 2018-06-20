package com.test.part2.persistence.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "row")
public class Row {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Integer number;

    @OneToMany(mappedBy = "row", cascade = CascadeType.ALL)
    private Set<Seat> seats;

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

    public Set<Seat> getSeats() {
        return seats;
    }

    public void setSeats(Set<Seat> seats) {
        this.seats = seats;
    }
}
