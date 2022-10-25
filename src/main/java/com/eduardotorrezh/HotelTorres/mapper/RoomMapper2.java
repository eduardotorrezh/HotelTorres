package com.eduardotorrezh.HotelTorres.mapper;

import com.eduardotorrezh.HotelTorres.dto.RoomDTO;
import com.eduardotorrezh.HotelTorres.dto.RoomTypeDTO;
import com.eduardotorrezh.HotelTorres.entity.Room;
import com.eduardotorrezh.HotelTorres.entity.RoomType;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper
public interface  RoomMapper2 {
    RoomMapper2 INSTANCE = Mappers.getMapper(RoomMapper2.class);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "floor", target = "floor")
    @Mapping(source = "maxGuest", target = "maxGuest")
    @Mapping(source = "roomTypeDTO", target = "roomType")
    @Mapping(source = "hotelDTO", target = "hotel")
    void toEntity(RoomDTO roomDTO, @MappingTarget Room room);

    @InheritInverseConfiguration
    RoomDTO toDTO(Room room);

    @Mapper( unmappedTargetPolicy = ReportingPolicy.IGNORE )
    interface LenientMapper {

        // ChildDto.name will be mapped to ChildEntity.name (based on name), explicit ignore would still be required
        // ChildDto.age will not be mapped ChildDto.childAge (ignore) and there's no warning either
        // this is handy when @BeanMapping#ignoreByDefault causes too many manual mappings to add
        void toEntity(RoomTypeDTO roomTypeDTO, @MappingTarget RoomType roomType);
    }

}
