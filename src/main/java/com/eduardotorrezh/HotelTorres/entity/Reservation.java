package com.eduardotorrezh.HotelTorres.entity;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "reservation")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "room")
    Room room;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "guest")
    Guest guest;

    @Column(name = "start_date")
    Date startDate;

    @Column(name = "end_date")
    Date endDate;

    @Column(name = "check_in")
    Boolean checkIn;

    @Column(name = "check_out")
    Boolean checkOut;

    @Column(name = "kids")
    int kids;

    @OneToMany(mappedBy = "reservation_id")
    List<GuestInReservation> guestInReservationList;

}
