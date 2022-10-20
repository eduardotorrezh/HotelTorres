package com.eduardotorrezh.HotelTorres.dao;

import com.eduardotorrezh.HotelTorres.entity.GuestType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuestTypeDAO extends JpaRepository<GuestType, Long> {

}
