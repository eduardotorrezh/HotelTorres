package com.eduardotorrezh.HotelTorres.service;

import com.eduardotorrezh.HotelTorres.dto.HotelDTO;
import com.eduardotorrezh.HotelTorres.dto.request.HotelRequestDTO;
import com.eduardotorrezh.HotelTorres.dto.response.HotelResponseDTO;

import java.util.List;

public interface HotelService {

    HotelResponseDTO createObject(HotelRequestDTO hotelRequestDTO);

    HotelDTO updateObject(HotelDTO HotelDTO);

    List<HotelDTO> getAll();

    HotelResponseDTO getObjectById(Long id);

    void deleteObjectById(Long id);

}
