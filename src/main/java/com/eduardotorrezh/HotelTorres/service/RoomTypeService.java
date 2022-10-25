package com.eduardotorrezh.HotelTorres.service;

import com.eduardotorrezh.HotelTorres.dto.RoomTypeDTO;

import java.util.List;

public interface RoomTypeService {

    RoomTypeDTO createObject(RoomTypeDTO roomTypeDTO);

    RoomTypeDTO updateObject(RoomTypeDTO roomTypeDTO);

    List<RoomTypeDTO> getAll();

    RoomTypeDTO getObjectById(Long id) throws Exception;

}
