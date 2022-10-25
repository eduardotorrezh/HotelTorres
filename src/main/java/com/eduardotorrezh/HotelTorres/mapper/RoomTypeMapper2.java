package com.eduardotorrezh.HotelTorres.mapper;

import com.eduardotorrezh.HotelTorres.dto.RoomTypeDTO;
import com.eduardotorrezh.HotelTorres.entity.RoomType;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RoomTypeMapper2 {

    RoomTypeMapper2 INSTANCE = Mappers.getMapper(RoomTypeMapper2.class);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    RoomTypeDTO toDTO(RoomType roomType);

    @InheritInverseConfiguration
    RoomType toEntity(RoomTypeDTO roomTypeDTO);

}