package com.eduardotorrezh.HotelTorres.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Entity
@Table(name = "bitacora_reservaciones")
public class BitacoraReservaciones {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "hotel_name")
    String hotelName;

    @Column(name = "room_name")
    String roomName;

    @Column(name = "guest_first_name")
    String guestFirstName;

    @Column(name = "guest_last_name")
    String guestLastName;

    @Column(name = "guest_email")
    String guestEmail;

    @Column(name = "start_date")
    Date starDate;

    @Column(name = "end_date")
    Date endDate;

}
