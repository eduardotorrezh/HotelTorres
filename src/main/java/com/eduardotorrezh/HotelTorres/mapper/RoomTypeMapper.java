package com.eduardotorrezh.HotelTorres.mapper;

import com.eduardotorrezh.HotelTorres.dto.RoomTypeDTO;
import com.eduardotorrezh.HotelTorres.entity.RoomType;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class RoomTypeMapper {

    public RoomTypeDTO toDTO(RoomType roomType) {
        RoomTypeDTO roomTypeDTO = new RoomTypeDTO();
        roomTypeDTO.setId(roomType.getId());
        roomTypeDTO.setName(roomType.getName());
        return roomTypeDTO;
    }

    public RoomType toEntity(RoomTypeDTO roomTypeDTO) {
        RoomType roomType = new RoomType();
        roomType.setId(roomTypeDTO.getId());
        roomType.setName(roomTypeDTO.getName());
        return roomType;
    }

    public Optional<RoomTypeDTO> toOptionalDTO(RoomType roomType){
        Optional<RoomTypeDTO> roomTypeDTOOptional = Optional.of(toDTO(roomType));
        return roomTypeDTOOptional;
    }

    public List<RoomTypeDTO> toDTOList(List<RoomType> roomTypeList) {
        return roomTypeList.stream().map(roomType -> toDTO(roomType)).collect(Collectors.toList());
    }

}
