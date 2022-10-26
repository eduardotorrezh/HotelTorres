package com.eduardotorrezh.HotelTorres.service.imp;

import com.eduardotorrezh.HotelTorres.dao.HotelDAO;
import com.eduardotorrezh.HotelTorres.dao.RoomDAO;
import com.eduardotorrezh.HotelTorres.dto.RoomDTO;
import com.eduardotorrezh.HotelTorres.dto.request.RoomRequestDTO;
import com.eduardotorrezh.HotelTorres.dto.response.RoomResposeDTO;
import com.eduardotorrezh.HotelTorres.entity.Hotel;
import com.eduardotorrezh.HotelTorres.entity.Room;
import com.eduardotorrezh.HotelTorres.exception.BadRequestException;
import com.eduardotorrezh.HotelTorres.exception.ObjectNotFoundException;
import com.eduardotorrezh.HotelTorres.mapper.HotelMapper;
import com.eduardotorrezh.HotelTorres.mapper.RoomMapper;
import com.eduardotorrezh.HotelTorres.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RoomServiceImplement implements RoomService {

    @Autowired
    RoomMapper roomMapper;
    @Autowired
    HotelMapper hotelMapper;
    @Autowired
    RoomDAO roomDAO;
    @Autowired
    HotelDAO hotelDAO;

    @Override
    public RoomDTO createObject(RoomDTO roomDTO) {
        Optional<Hotel> hotel = hotelDAO.findById(roomDTO.getHotelDTO().getId());
        if (hotel.isEmpty()) throw new ObjectNotFoundException("Hotel not found");
        return roomMapper.toDTO(roomDAO.save(roomMapper.toEntity(roomDTO, hotel.get())), hotelMapper.toDTO(hotel.get()));
    }

    @Override
    public RoomResposeDTO updateObject(RoomRequestDTO roomRequestDTO) {
        if (Objects.isNull(roomRequestDTO.getId())) throw new BadRequestException("Id cant be null");
        Optional<Room> optionalRoom = roomDAO.findById(roomRequestDTO.getId());
        if (optionalRoom.isEmpty()) throw new ObjectNotFoundException(roomRequestDTO.getId());
        return roomMapper.toResponse(roomDAO.save(roomMapper.updateEntity(optionalRoom.get(), roomRequestDTO)), hotelMapper.toDTO(optionalRoom.get().getHotel()));
    }

    @Override
    public List<RoomDTO> getAll() {
        return roomDAO.findAll().stream().map(room ->
                roomMapper.toDTOWithHotel(room, hotelMapper.toDTO(room.getHotel())))
                .collect(Collectors.toList());
    }

    @Override
    public List<RoomDTO> getAllByHotelId(Long id) {
        Optional<Hotel> optionalHotel = hotelDAO.findById(id);
        if (optionalHotel.isEmpty()) throw new ObjectNotFoundException("Hotel not found");
        return roomMapper.toDTOListWithHotelDTO(roomDAO.findByHotelId(optionalHotel.get().getId()), hotelMapper.toDTO(optionalHotel.get()));
    }

    @Override
    public RoomDTO getObjectById(Long id) {
        Optional<Room> room = roomDAO.findById(id);
        if (room.isEmpty()) throw new ObjectNotFoundException(id);
        return roomMapper.toDTOWithHotel(room.get(), hotelMapper.toDTO(room.get().getHotel()));
    }

    @Override
    public void deleteObjectById(Long id) {
        Optional<Room> optionalRoom = roomDAO.findById(id);
        if (optionalRoom.isEmpty()) throw new ObjectNotFoundException("Object dont exist");
        roomDAO.delete(optionalRoom.get());
    }

}
