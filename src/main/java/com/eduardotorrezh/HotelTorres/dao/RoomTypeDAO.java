package com.eduardotorrezh.HotelTorres.dao;

import com.eduardotorrezh.HotelTorres.entity.RoomType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomTypeDAO extends JpaRepository<RoomType, Long> {

}
