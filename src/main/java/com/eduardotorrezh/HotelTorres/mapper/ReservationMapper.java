package com.eduardotorrezh.HotelTorres.mapper;

import com.eduardotorrezh.HotelTorres.dto.GuestDTO;
import com.eduardotorrezh.HotelTorres.dto.ReservationRequestDTO;
import com.eduardotorrezh.HotelTorres.dto.RoomDTO;
import com.eduardotorrezh.HotelTorres.dto.response.ReservationResponseDTO;
import com.eduardotorrezh.HotelTorres.entity.Guest;
import com.eduardotorrezh.HotelTorres.entity.Reservation;
import com.eduardotorrezh.HotelTorres.entity.Room;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ReservationMapper {

    public ReservationResponseDTO toResponseDTO(Reservation reservation, GuestDTO guestDTO, RoomDTO roomDTO, List<GuestDTO> guestDTOList) {
        ReservationResponseDTO reservationResponseDTO = new ReservationResponseDTO();
        reservationResponseDTO.setId(reservation.getId());
        reservationResponseDTO.setGuestDTO(guestDTO);
        reservationResponseDTO.setGuestDTOList(guestDTOList);
        reservationResponseDTO.setRoomDTO(roomDTO);
        reservationResponseDTO.setStartDate(reservation.getStartDate());
        reservationResponseDTO.setEndDate(reservation.getEndDate());
        return reservationResponseDTO;
    }

    public Reservation toEntity(ReservationRequestDTO reservationRequestDTO) {
        Reservation reservation = new Reservation();
        reservation.setStartDate(reservationRequestDTO.getStartDate());
        reservation.setEndDate(reservationRequestDTO.getEndDate());
        reservation.setKids(reservationRequestDTO.getKids());
        reservation.setGuest(buildGuest(reservationRequestDTO.getGuestDTO().getId()));
        reservation.setRoom(buildRoom(reservationRequestDTO.getRoomDTO().getId()));
        reservation.setCheckIn(reservationRequestDTO.getCheckIn());
        return reservation;
    }

    Guest buildGuest(long id) {
        Guest guest = new Guest();
        guest.setId(id);
        return guest;
    }
    Room buildRoom(long id) {
        Room guest = new Room();
        guest.setId(id);
        return guest;
    }

}
