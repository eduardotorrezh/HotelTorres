package com.eduardotorrezh.HotelTorres.service;

import com.eduardotorrezh.HotelTorres.dto.ReservationRequestDTO;
import com.eduardotorrezh.HotelTorres.dto.response.ReservationResponseDTO;

import java.util.List;

public interface ReservationService {

    ReservationResponseDTO createObject(ReservationRequestDTO reservationRequestDTO);

    ReservationRequestDTO updateObject(ReservationRequestDTO reservationRequestDTO);

    List<ReservationRequestDTO> getAllObjects();

    ReservationRequestDTO getObjectById(Long id);

}
