package com.eduardotorrezh.HotelTorres.service;

import com.eduardotorrezh.HotelTorres.dto.RoomTypeDTO;

import java.util.List;
import java.util.Optional;

public interface RoomTypeService {

    RoomTypeDTO createObject(RoomTypeDTO roomTypeDTO);

    RoomTypeDTO updateObject(RoomTypeDTO roomTypeDTO);

    List<RoomTypeDTO> getAll();

    Optional<RoomTypeDTO> getObjectById(Long id);

}
