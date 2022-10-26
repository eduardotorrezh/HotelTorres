package com.eduardotorrezh.HotelTorres.service.imp;

import com.eduardotorrezh.HotelTorres.dao.HotelDAO;
import com.eduardotorrezh.HotelTorres.dao.RoomDAO;
import com.eduardotorrezh.HotelTorres.dto.HotelDTO;
import com.eduardotorrezh.HotelTorres.dto.request.HotelRequestDTO;
import com.eduardotorrezh.HotelTorres.dto.response.HotelResponseDTO;
import com.eduardotorrezh.HotelTorres.entity.Hotel;
import com.eduardotorrezh.HotelTorres.entity.Room;
import com.eduardotorrezh.HotelTorres.exception.BadRequestException;
import com.eduardotorrezh.HotelTorres.exception.ObjectNotFoundException;
import com.eduardotorrezh.HotelTorres.mapper.HotelMapper;
import com.eduardotorrezh.HotelTorres.mapper.RoomMapper;
import com.eduardotorrezh.HotelTorres.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class HotelServiceImplement implements HotelService {

    @Autowired
    HotelDAO hotelDAO;
    @Autowired
    RoomDAO roomDAO;

    @Autowired
    HotelMapper hotelMapper;
    @Autowired
    RoomMapper roomMapper;

    @Override
    public HotelResponseDTO createObject(HotelRequestDTO hotelRequestDTO) {
        Hotel hotel = hotelDAO.save(hotelMapper.toEntityWithoutRooms(hotelRequestDTO));
        if (Objects.isNull(hotelRequestDTO.getRoomDTOList()))
            return hotelMapper.toResponseDTO(hotelMapper.toDTO(hotel), null);
        List<Room> roomList = roomMapper.toEntityListWithHotel(hotelRequestDTO.getRoomDTOList(), hotel);
//        HotelResponseDTO hotelResponseDTO = hotelMapper.toResponseDTO(hotelMapper.toDTO(hotel), roomMapper.toDTOList(roomDAO.saveAll(roomList)));
        return hotelMapper.toResponseDTO(hotelMapper.toDTO(hotel), roomMapper.toDTOList(roomDAO.saveAll(roomList)));
    }

    @Override
    public HotelDTO updateObject(HotelDTO hotelDTO) {
        if (Objects.isNull(hotelDTO.getId())) throw new BadRequestException("Id cant be null");
        Optional<Hotel> optionalHotel = hotelDAO.findById(hotelDTO.getId());
        if (optionalHotel.isEmpty()) throw new ObjectNotFoundException(hotelDTO.getId());
        return hotelMapper.toDTO(hotelDAO.save(hotelMapper.toEntity(hotelDTO)));
    }

    @Override
    public List<HotelDTO> getAll() {
        return hotelMapper.toDTOList(hotelDAO.findAll());
    }

    @Override
    public HotelResponseDTO getObjectById(Long id) {
        Optional<Hotel> HotelOptional = hotelDAO.findById(id);
        if (HotelOptional.isEmpty()) throw new ObjectNotFoundException(id);
//        HotelResponseDTO hotelResponseDTO = hotelMapper.toResponseDTO(hotelMapper.toDTO(HotelOptional.get()), roomMapper.toDTOList(HotelOptional.get().getRoomList()));
        return hotelMapper.toResponseDTO(hotelMapper.toDTO(HotelOptional.get()), roomMapper.toDTOList(HotelOptional.get().getRoomList()));
    }

    @Override
    public void deleteObjectById(Long id) {
        Optional<Hotel> hotel = hotelDAO.findById(id);
        if (hotel.isEmpty()) throw new ObjectNotFoundException(id);
        hotelDAO.delete(hotel.get());

    }
}
