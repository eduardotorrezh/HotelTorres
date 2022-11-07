package com.eduardotorrezh.HotelTorres.service.imp;

import com.eduardotorrezh.HotelTorres.dao.GuestDAO;
import com.eduardotorrezh.HotelTorres.dao.GuestInReservationDAO;
import com.eduardotorrezh.HotelTorres.dao.GuestTypeDAO;
import com.eduardotorrezh.HotelTorres.dao.ReservationDAO;
import com.eduardotorrezh.HotelTorres.dto.ReservationRequestDTO;
import com.eduardotorrezh.HotelTorres.dto.response.ReservationResponseDTO;
import com.eduardotorrezh.HotelTorres.entity.Guest;
import com.eduardotorrezh.HotelTorres.entity.GuestInReservation;
import com.eduardotorrezh.HotelTorres.entity.Reservation;
import com.eduardotorrezh.HotelTorres.exception.BadRequestException;
import com.eduardotorrezh.HotelTorres.mapper.GuestMapper;
import com.eduardotorrezh.HotelTorres.mapper.GuestTypeMapper;
import com.eduardotorrezh.HotelTorres.mapper.ReservationMapper;
import com.eduardotorrezh.HotelTorres.mapper.RoomMapper;
import com.eduardotorrezh.HotelTorres.service.ReservationService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class ReservationServiceImplement implements ReservationService {

    @Autowired
    ReservationDAO reservationDAO;
    @Autowired
    GuestInReservationDAO guestInReservationDAO;
    @Autowired
    GuestDAO guestDAO;
    @Autowired
    GuestTypeDAO guestTypeDAO;
    @Autowired
    GuestMapper guestMapper;
    @Autowired
    GuestTypeMapper guestTypeMapper;
    @Autowired
    ReservationMapper reservationMapper;
    @Autowired
    RoomMapper roomMapper;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public ReservationResponseDTO createObject(ReservationRequestDTO reservationRequestDTO) {

        List<Guest> guestList = reservationRequestDTO.getGuestDTOList().stream().map(guestDTO -> {
            if (Objects.isNull(guestDTO.getId()) || !guestDAO.existsById(guestDTO.getId())) {
                try {
                    return guestDAO.save(guestMapper.toEntity(guestDTO));
//                    return guestMapper.toDTO(guest, guestDTO.getGuestTypeDTO());
                } catch (Exception e) {
                    throw new BadRequestException("Can not create guest");
                }
            }
            return guestMapper.toEntity(guestDTO);
        }).collect(Collectors.toList());

        Reservation reservation = reservationDAO.save(reservationMapper.toEntity(reservationRequestDTO));
        List<GuestInReservation> guestInReservationList = guestList.stream().map(guest -> {
            GuestInReservation guestInReservation = new GuestInReservation();
            guestInReservation.setReservation(reservation);
            guestInReservation.setGuest(guest);
            guestInReservation.setRoom(reservation.getRoom());
            return guestInReservationDAO.save(guestInReservation);
        }).collect(Collectors.toList());

        return reservationMapper.toResponseDTO(reservation, guestMapper.toDTO(reservation.getGuest(), guestTypeMapper.toDTO(reservation.getGuest().getGuestType())), roomMapper.toDTO(reservation.getRoom()), guestMapper.toDTOList(guestList));
    }

    @Override
    public ReservationRequestDTO updateObject(ReservationRequestDTO reservationRequestDTO) {
        return null;
    }

    @Override
    public List<ReservationRequestDTO> getAllObjects() {
        return null;
    }

    @Override
    public ReservationRequestDTO getObjectById(Long id) {
        return null;
    }
}
