package com.eduardotorrezh.HotelTorres.mapper;

import com.eduardotorrezh.HotelTorres.dto.HotelDTO;
import com.eduardotorrezh.HotelTorres.dto.RoomDTO;
import com.eduardotorrezh.HotelTorres.dto.request.HotelRequestDTO;
import com.eduardotorrezh.HotelTorres.dto.response.HotelResponseDTO;
import com.eduardotorrezh.HotelTorres.entity.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class HotelMapper {

    @Autowired
    RoomMapper roomMapper;

    public HotelDTO toDTO(Hotel hotel) {
        HotelDTO hotelDTO = new HotelDTO();
        hotelDTO.setId(hotel.getId());
        hotelDTO.setName(hotel.getName());
        hotelDTO.setDescription(hotel.getDescription());
        hotelDTO.setStars(hotel.getStars());
        return hotelDTO;
    }
    public HotelResponseDTO toResponseDTO(HotelDTO hotelDTO, List<RoomDTO> roomDTOList) {
        HotelResponseDTO hotelResponseDTO = new HotelResponseDTO();
        hotelResponseDTO.setId(hotelDTO.getId());
        hotelResponseDTO.setName(hotelDTO.getName());
        hotelResponseDTO.setDescription(hotelDTO.getDescription());
        hotelResponseDTO.setStars(hotelDTO.getStars());
        hotelResponseDTO.setRoomDTOList(roomDTOList);
        return hotelResponseDTO;
    }

//    public HotelRequestDTO toDTOWithRooms(Hotel hotel) {
//        HotelRequestDTO hotelDTO = new HotelRequestDTO();
//        hotelDTO.setId(hotel.getId());
//        hotelDTO.setName(hotel.getName());
//        hotelDTO.setDescription(hotel.getDescription());
//        hotelDTO.setStars(hotel.getStars());
//        List<Room> rooomList = hotel.getRoomList();
//        if (rooomList != null && !rooomList.isEmpty())
//            hotelDTO.setRoomDTOList(hotel.getRoomList().stream()
//                    .map(room -> roomMapper.toDTO(room))
//                    .collect(Collectors.toList()));
//        return hotelDTO;
//    }

    public Hotel toEntity(HotelDTO hotelDTO) {
        Hotel hotel = new Hotel();
        hotel.setId(hotelDTO.getId());
        hotel.setName(hotelDTO.getName());
        hotel.setDescription(hotelDTO.getDescription());
        hotel.setStars(hotelDTO.getStars());
        return hotel;
    }

//    public Hotel toEntity(HotelRequestDTO hotelRequestDTO) {
//        Hotel hotel = new Hotel();
//        hotel.setId(hotelRequestDTO.getId());
//        hotel.setName(hotelRequestDTO.getName());
//        hotel.setDescription(hotelRequestDTO.getDescription());
//        hotel.setStars(hotelRequestDTO.getStars());
//        List<RoomDTO> roomDTOList = hotelRequestDTO.getRoomDTOList();
//        if (roomDTOList != null && !roomDTOList.isEmpty())
//        hotel.setRoomList(roomMapper.toEntityList(hotelRequestDTO.getRoomDTOList())
//                .stream().map(room -> {
//                    room.setHotel(hotel);
//                    return room;
//                })
//                .collect(Collectors.toList()));
//        return hotel;
//    }

    public Hotel toEntityWithoutRooms(HotelRequestDTO hotelRequestDTO) {
        Hotel hotel = new Hotel();
        hotel.setId(hotelRequestDTO.getId());
        hotel.setName(hotelRequestDTO.getName());
        hotel.setDescription(hotelRequestDTO.getDescription());
        hotel.setStars(hotelRequestDTO.getStars());
        return hotel;
    }

    public Optional<HotelDTO> toOptionalDTO(Hotel hotel){
        Optional<HotelDTO> hotelDTOOptional = Optional.of(toDTO(hotel));
        return hotelDTOOptional;
    }

    public List<HotelDTO> toDTOList(List<Hotel> hotelList) {
        return hotelList.stream().map(hotel -> toDTO(hotel)).collect(Collectors.toList());
    }

}
