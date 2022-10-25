package com.eduardotorrezh.HotelTorres.service.imp;

import com.eduardotorrezh.HotelTorres.dao.HotelDAO;
import com.eduardotorrezh.HotelTorres.dao.RoomDAO;
import com.eduardotorrezh.HotelTorres.dto.HotelDTO;
import com.eduardotorrezh.HotelTorres.dto.request.HotelRequestDTO;
import com.eduardotorrezh.HotelTorres.dto.response.HotelResponseDTO;
import com.eduardotorrezh.HotelTorres.entity.Hotel;
import com.eduardotorrezh.HotelTorres.entity.Room;
import com.eduardotorrezh.HotelTorres.mapper.HotelMapper;
import com.eduardotorrezh.HotelTorres.mapper.HotelMapper2;
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
            return hotelMapper.toResponseDTO(hotelMapper.toDTO(hotel),null);
        List<Room> roomList = roomMapper.toEntityListWithHotel(hotelRequestDTO.getRoomDTOList(),hotel);
        HotelResponseDTO hotelResponseDTO = hotelMapper.toResponseDTO(hotelMapper.toDTO(hotel), roomMapper.toDTOList(roomDAO.saveAll(roomList)));
        return hotelResponseDTO;
    }

    @Override
    public HotelDTO updateObject(HotelDTO HotelDTO) {
        return hotelMapper.toDTO(hotelDAO.save(hotelMapper.toEntity(HotelDTO)));
    }

    @Override
    public List<HotelDTO> getAll() {
        return hotelMapper.toDTOList(hotelDAO.findAll());
    }

    @Override
    public HotelResponseDTO getObjectById(Long id) {
        Optional<Hotel> HotelOptional = hotelDAO.findById(id);
        if (!HotelOptional.isEmpty())
            return null;
        return HotelMapper2.INSTANCE.toResponseDTO(HotelOptional.get(), new HotelResponseDTO());
//        HotelResponseDTO hotelResponseDTO = hotelMapper.toResponseDTO(hotelMapper.toDTO(HotelOptional.get()), roomMapper.toDTOList(HotelOptional.get().getRoomList()));
//        return hotelResponseDTO;
    }

    @Override
    public void deleteObjectById(Long id) throws Exception {
        Optional<Hotel> hotel = hotelDAO.findById(id);
        if (!hotel.isEmpty())
            throw new Exception("Object dont exist");
        hotelDAO.delete(hotel.get());

    }
}
