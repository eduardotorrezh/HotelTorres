package com.eduardotorrezh.HotelTorres.dao;

import com.eduardotorrezh.HotelTorres.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomDAO extends JpaRepository<Room, Long> {

    List<Room> findByHotelId(Long id);
}
