package com.eduardotorrezh.HotelTorres.mapper;

import com.eduardotorrezh.HotelTorres.dto.GuestDTO;
import com.eduardotorrezh.HotelTorres.dto.GuestTypeDTO;
import com.eduardotorrezh.HotelTorres.entity.Guest;
import com.eduardotorrezh.HotelTorres.entity.GuestType;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class GuestMapper {

    public GuestDTO toDTO(Guest guest, GuestTypeDTO guestTypeDTO) {
        GuestDTO guestDTO = new GuestDTO();
        guestDTO.setId(guest.getId());
        guestDTO.setFirstName(guest.getFirstName());
        guestDTO.setLastName(guest.getLastName());
        guestDTO.setEmail(guest.getEmail());
        guestDTO.setGuestTypeDTO(guestTypeDTO);
        return guestDTO;
    }

    public GuestDTO toDTO(Guest guest) {
        GuestDTO guestDTO = new GuestDTO();
        guestDTO.setId(guest.getId());
        guestDTO.setFirstName(guest.getFirstName());
        guestDTO.setLastName(guest.getLastName());
        guestDTO.setEmail(guest.getEmail());
        guestDTO.setGuestTypeDTO(buildGuestTypeDTO(guest.getGuestType().getId()));
        return guestDTO;
    }

    public Guest toEntity(GuestDTO guestDTO) {
        Guest guest = new Guest();
        guest.setId(guestDTO.getId());
        guest.setFirstName(guestDTO.getFirstName());
        guest.setLastName(guestDTO.getLastName());
        guest.setEmail(guestDTO.getEmail());
        guest.setGuestType(buildGuestType(guestDTO.getGuestTypeDTO().getId()));
        return guest;
    }

    public List<GuestDTO> toDTOList(List<Guest> guestList){
        return guestList.stream().map(guest -> toDTO(guest))
                .collect(Collectors.toList());
    }

    GuestType buildGuestType(long id){
        GuestType guestType = new GuestType();
        guestType.setId(id);
        return guestType;
    }

    GuestTypeDTO buildGuestTypeDTO(long id){
        GuestTypeDTO guestType = new GuestTypeDTO();
        guestType.setId(id);
        return guestType;
    }

}
