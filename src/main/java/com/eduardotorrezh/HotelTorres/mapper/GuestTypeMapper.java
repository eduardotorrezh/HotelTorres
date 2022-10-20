package com.eduardotorrezh.HotelTorres.mapper;

import com.eduardotorrezh.HotelTorres.dto.GuestTypeDTO;
import com.eduardotorrezh.HotelTorres.entity.GuestType;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class GuestTypeMapper {

    public GuestTypeDTO toDTO(GuestType guestType) {
        GuestTypeDTO guestTypeDTO = new GuestTypeDTO();
        guestTypeDTO.setId(guestType.getId());
        guestTypeDTO.setName(guestType.getName());
        return guestTypeDTO;
    }

    public GuestType toEntity(GuestTypeDTO guestTypeDTO) {
        GuestType guestType = new GuestType();
        guestType.setId(guestTypeDTO.getId());
        guestType.setName(guestTypeDTO.getName());
        return guestType;
    }

    public Optional<GuestTypeDTO> toOptionalDTO(GuestType guestType) {
        Optional<GuestTypeDTO> guestTypeDTO = Optional.of(toDTO(guestType));
        return guestTypeDTO;
    }

    public List<GuestTypeDTO> toDTOList(List<GuestType> guestTypeList) {
        return guestTypeList.stream().map(guestType -> toDTO(guestType)).collect(Collectors.toList());
    }

}
