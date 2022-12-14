package com.eduardotorrezh.HotelTorres.service.imp;

import com.eduardotorrezh.HotelTorres.dao.RoomTypeDAO;
import com.eduardotorrezh.HotelTorres.dto.RoomTypeDTO;
import com.eduardotorrezh.HotelTorres.entity.RoomType;
import com.eduardotorrezh.HotelTorres.exception.ObjectNotFoundException;
import com.eduardotorrezh.HotelTorres.mapper.RoomTypeMapper;
import com.eduardotorrezh.HotelTorres.service.RoomTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomTypeServiceImplement implements RoomTypeService {

    @Autowired
    RoomTypeMapper roomTypeMapper;
    @Autowired
    RoomTypeDAO roomTypeDAO;

    @Override
    public RoomTypeDTO createObject(RoomTypeDTO roomTypeDTO) {
        return roomTypeMapper.toDTO(roomTypeDAO.save(roomTypeMapper.toEntity(roomTypeDTO)));
    }

    @Override
    public RoomTypeDTO updateObject(RoomTypeDTO roomTypeDTO) {
        return roomTypeMapper.toDTO(roomTypeDAO.save(roomTypeMapper.toEntity(roomTypeDTO)));
    }

    @Override
    public List<RoomTypeDTO> getAll() {
        return roomTypeMapper.toDTOList(roomTypeDAO.findAll());
    }

    @Override
    public RoomTypeDTO getObjectById(Long id) {
        Optional<RoomType> roomTypeOptional = roomTypeDAO.findById(id);
        if (roomTypeOptional.isEmpty()) throw new ObjectNotFoundException(id);
        return roomTypeMapper.toDTO(roomTypeOptional.get());
    }
}
