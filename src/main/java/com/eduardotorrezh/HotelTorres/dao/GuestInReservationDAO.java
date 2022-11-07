package com.eduardotorrezh.HotelTorres.dao;

import com.eduardotorrezh.HotelTorres.entity.GuestInReservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuestInReservationDAO extends JpaRepository<GuestInReservation, Long> {

}
