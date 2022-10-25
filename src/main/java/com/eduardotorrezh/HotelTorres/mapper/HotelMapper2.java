package com.eduardotorrezh.HotelTorres.mapper;


import com.eduardotorrezh.HotelTorres.dto.HotelDTO;
import com.eduardotorrezh.HotelTorres.dto.RoomDTO;
import com.eduardotorrezh.HotelTorres.dto.response.HotelResponseDTO;
import com.eduardotorrezh.HotelTorres.entity.Hotel;
import com.eduardotorrezh.HotelTorres.entity.Room;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper
public interface HotelMapper2 {

    HotelMapper2 INSTANCE = Mappers.getMapper(HotelMapper2.class);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "stars", target = "stars")
    @Mapping(source = "roomList", target = "roomDTOList")
    HotelResponseDTO toResponseDTO(Hotel hotel, @MappingTarget HotelResponseDTO hotelResponseDTO);

    @InheritInverseConfiguration
    HotelDTO toDTO(Hotel room);

    @InheritInverseConfiguration
    HotelResponseDTO toEntity(Hotel room);

    @Mapper( unmappedTargetPolicy = ReportingPolicy.IGNORE )
    interface LenientMapper {
        // ChildDto.name will be mapped to ChildEntity.name (based on name), explicit ignore would still be required
        // ChildDto.age will not be mapped ChildDto.childAge (ignore) and there's no warning either
        // this is handy when @BeanMapping#ignoreByDefault causes too many manual mappings to add
        void toEntity(RoomDTO roomDTO, @MappingTarget Room room);

        @InheritInverseConfiguration
        void toDTO(Room room, @MappingTarget RoomDTO roomDTO);
    }
}
