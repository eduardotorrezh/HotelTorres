package com.eduardotorrezh.HotelTorres.service;

import com.eduardotorrezh.HotelTorres.dto.RoomDTO;
import com.eduardotorrezh.HotelTorres.dto.request.RoomRequestDTO;
import com.eduardotorrezh.HotelTorres.dto.response.RoomResposeDTO;

import java.util.List;

public interface RoomService {

    RoomDTO createObject(RoomDTO roomDTO);

    RoomResposeDTO updateObject(RoomRequestDTO roomDTO);

    List<RoomDTO> getAll();

    List<RoomDTO> getAllByHotelId(Long id);

    RoomDTO getObjectById(Long id);

    void deleteObjectById(Long id);

}
