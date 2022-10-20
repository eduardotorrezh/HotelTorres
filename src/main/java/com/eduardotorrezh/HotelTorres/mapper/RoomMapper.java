package com.eduardotorrezh.HotelTorres.mapper;

import com.eduardotorrezh.HotelTorres.dto.HotelDTO;
import com.eduardotorrezh.HotelTorres.dto.RoomDTO;
import com.eduardotorrezh.HotelTorres.dto.request.RoomRequestDTO;
import com.eduardotorrezh.HotelTorres.dto.response.RoomResposeDTO;
import com.eduardotorrezh.HotelTorres.entity.Hotel;
import com.eduardotorrezh.HotelTorres.entity.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class RoomMapper {
    @Autowired
    RoomTypeMapper roomTypeMapper;

    public RoomDTO toDTO(Room room) {
        RoomDTO roomDTO = new RoomDTO();
        roomDTO.setId(room.getId());
        roomDTO.setName(room.getName());
        roomDTO.setDescription(room.getDescription());
        roomDTO.setFloor(room.getFloor());
        roomDTO.setMaxGuest(room.getMaxGuest());
        roomDTO.setRoomTypeDTO(roomTypeMapper.toDTO(room.getRoomType()));
        return roomDTO;
    }

    public Room updateEntity(Room originalRoom, RoomRequestDTO roomRequestDTO) {
        Room room = new Room();
        room.setId(roomRequestDTO.getId());
        room.setName(roomRequestDTO.getName());
        room.setDescription(roomRequestDTO.getDescription());
        room.setFloor(roomRequestDTO.getFloor());
        room.setMaxGuest(roomRequestDTO.getMaxGuest());
        room.setRoomType(roomTypeMapper.toEntity(roomRequestDTO.getRoomTypeDTO()));
        room.setHotel(originalRoom.getHotel());
        return room;
    }

    public RoomDTO toDTOWithHotel(Room room, HotelDTO hotelDTO) {
        RoomDTO roomDTO = new RoomDTO();
        roomDTO.setId(room.getId());
        roomDTO.setName(room.getName());
        roomDTO.setDescription(room.getDescription());
        roomDTO.setFloor(room.getFloor());
        roomDTO.setMaxGuest(room.getMaxGuest());
        roomDTO.setRoomTypeDTO(roomTypeMapper.toDTO(room.getRoomType()));
        roomDTO.setHotelDTO(hotelDTO);
        return roomDTO;
    }

    public RoomDTO toDTO(Room room, HotelDTO hotelDTO) {
        RoomDTO roomDTO = new RoomDTO();
        roomDTO.setId(room.getId());
        roomDTO.setName(room.getName());
        roomDTO.setDescription(room.getDescription());
        roomDTO.setFloor(room.getFloor());
        roomDTO.setMaxGuest(room.getMaxGuest());
        roomDTO.setRoomTypeDTO(roomTypeMapper.toDTO(room.getRoomType()));
        roomDTO.setHotelDTO(hotelDTO);
        return roomDTO;
    }

    public Room toEntity(RoomDTO roomDTO) {
        Room room = new Room();
        room.setId(roomDTO.getId());
        room.setName(roomDTO.getName());
        room.setDescription(roomDTO.getDescription());
        room.setFloor(roomDTO.getFloor());
        room.setMaxGuest(roomDTO.getMaxGuest());
        room.setRoomType(roomTypeMapper.toEntity(roomDTO.getRoomTypeDTO()));
        return room;
    }

    public Room toEntity(RoomRequestDTO roomRequestDTO) {
        Room room = new Room();
        room.setId(roomRequestDTO.getId());
        room.setName(roomRequestDTO.getName());
        room.setDescription(roomRequestDTO.getDescription());
        room.setFloor(roomRequestDTO.getFloor());
        room.setMaxGuest(roomRequestDTO.getMaxGuest());
        room.setRoomType(roomTypeMapper.toEntity(roomRequestDTO.getRoomTypeDTO()));
        return room;
    }

    public RoomResposeDTO toResponse(Room room, HotelDTO hotelDTO) {
        RoomResposeDTO roomResposeDTO = new RoomResposeDTO();
        roomResposeDTO.setId(room.getId());
        roomResposeDTO.setName(room.getName());
        roomResposeDTO.setDescription(room.getDescription());
        roomResposeDTO.setFloor(room.getFloor());
        roomResposeDTO.setMaxGuest(room.getMaxGuest());
        roomResposeDTO.setRoomTypeDTO(roomTypeMapper.toDTO(room.getRoomType()));
        roomResposeDTO.setHotelDTO(hotelDTO);
        return roomResposeDTO;
    }

 public Room toEntity(RoomDTO roomDTO, Hotel hotel) {
        Room room = new Room();
        room.setId(roomDTO.getId());
        room.setName(roomDTO.getName());
        room.setDescription(roomDTO.getDescription());
        room.setFloor(roomDTO.getFloor());
        room.setMaxGuest(roomDTO.getMaxGuest());
        room.setHotel(hotel);
        room.setRoomType(roomTypeMapper.toEntity(roomDTO.getRoomTypeDTO()));
        return room;
    }

    public List<RoomDTO> toDTOList(List<Room> roomList) {
        return roomList.stream().map(room -> toDTO(room)).collect(Collectors.toList());
    }

    public List<RoomDTO> toDTOListWithHotelDTO(List<Room> roomList, HotelDTO hotelDTO) {
        return roomList.stream().map(room -> toDTOWithHotel(room, hotelDTO)).collect(Collectors.toList());
    }

    public List<Room> toEntityListWithHotel(List<RoomDTO> roomDTOList, Hotel hotel) {
//        if (Objects.isNull(roomDTOList))
//            return null;
        return roomDTOList.stream().map(roomDTO -> toEntity(roomDTO, hotel)).collect(Collectors.toList());
    }


}
