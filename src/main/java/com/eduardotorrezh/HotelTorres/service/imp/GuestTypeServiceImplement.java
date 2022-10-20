package com.eduardotorrezh.HotelTorres.service.imp;

import com.eduardotorrezh.HotelTorres.dao.GuestTypeDAO;
import com.eduardotorrezh.HotelTorres.dto.GuestTypeDTO;
import com.eduardotorrezh.HotelTorres.entity.GuestType;
import com.eduardotorrezh.HotelTorres.mapper.GuestTypeMapper;
import com.eduardotorrezh.HotelTorres.service.GuestTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GuestTypeServiceImplement implements GuestTypeService {

    @Autowired
    GuestTypeMapper guestTypeMapper;
    @Autowired
    GuestTypeDAO guestTypeDAO;

    @Override
    public GuestTypeDTO createObject(GuestTypeDTO guestTypeDTO) {
        return guestTypeMapper.toDTO(guestTypeDAO.save(guestTypeMapper.toEntity(guestTypeDTO)));
    }

    @Override
    public GuestTypeDTO updateObject(GuestTypeDTO guestTypeDTO) {
        return guestTypeMapper.toDTO(guestTypeDAO.save(guestTypeMapper.toEntity(guestTypeDTO)));
    }

    @Override
    public List<GuestTypeDTO> getAllObjects() {
        return guestTypeMapper.toDTOList(guestTypeDAO.findAll());
    }

    @Override
    public Optional<GuestTypeDTO> getObjectById(Long id) {
        Optional<GuestType> guestTypeOptional = guestTypeDAO.findById(id);
        return guestTypeMapper.toOptionalDTO(guestTypeOptional.isPresent() ? guestTypeOptional.get() : new GuestType());
    }

}
