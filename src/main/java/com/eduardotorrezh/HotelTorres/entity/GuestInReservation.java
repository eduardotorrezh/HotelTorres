package com.eduardotorrezh.HotelTorres.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Getter
@Setter
@Data
@Entity
@Table(name = "guest_in_reservation")
public class GuestInReservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "status")
    Boolean status = Boolean.FALSE;

    @Column(name = "guest_id")
    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    Guest guest;

    @Column(name = "room_id")
    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    Room room;

    @Column(name = "reservation_id")
    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    Reservation reservation;

}
