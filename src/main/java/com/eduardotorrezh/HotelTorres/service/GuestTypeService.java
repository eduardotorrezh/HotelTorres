package com.eduardotorrezh.HotelTorres.service;

import com.eduardotorrezh.HotelTorres.dto.GuestTypeDTO;

import java.util.List;
import java.util.Optional;

public interface GuestTypeService {

    GuestTypeDTO createObject(GuestTypeDTO guestTypeDTO);

    GuestTypeDTO updateObject(GuestTypeDTO guestTypeDTO);

    List<GuestTypeDTO> getAllObjects();

    Optional<GuestTypeDTO> getObjectById(Long id);

}
