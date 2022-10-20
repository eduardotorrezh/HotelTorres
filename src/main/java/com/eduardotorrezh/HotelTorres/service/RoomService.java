package com.eduardotorrezh.HotelTorres.service;

import com.eduardotorrezh.HotelTorres.dto.RoomDTO;
import com.eduardotorrezh.HotelTorres.dto.request.RoomRequestDTO;
import com.eduardotorrezh.HotelTorres.dto.response.RoomResposeDTO;

import java.util.List;

public interface RoomService {

    RoomDTO createObject(RoomDTO roomDTO) throws Exception;

    RoomResposeDTO updateObject(RoomRequestDTO roomDTO) throws Exception;

    List<RoomDTO> getAll();

    List<RoomDTO> getAllByHotelId(Long id) throws Exception;

    RoomDTO getObjectById(Long id) throws Exception;

    void deleteObjectById(Long id) throws Exception;

}
