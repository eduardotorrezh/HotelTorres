package com.eduardotorrezh.HotelTorres.dao;

import com.eduardotorrezh.HotelTorres.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelDAO extends JpaRepository<Hotel, Long> {

}
