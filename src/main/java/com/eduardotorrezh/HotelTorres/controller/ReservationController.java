package com.eduardotorrezh.HotelTorres.controller;

import com.eduardotorrezh.HotelTorres.dto.GuestTypeDTO;
import com.eduardotorrezh.HotelTorres.dto.ReservationRequestDTO;
import com.eduardotorrezh.HotelTorres.dto.response.ReservationResponseDTO;
import com.eduardotorrezh.HotelTorres.dto.response.ResponseDTO;
import com.eduardotorrezh.HotelTorres.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("reservation")
public class ReservationController {

    @Autowired
    ReservationService reservationService;

    @PostMapping()
    public ResponseEntity<ResponseDTO<ReservationResponseDTO>> create(@RequestBody ReservationRequestDTO reservationRequestDTO) {
        ResponseDTO responseDTO = new ResponseDTO(Boolean.TRUE, reservationService.createObject(reservationRequestDTO));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @PutMapping()
    public ResponseEntity<ResponseDTO<List<GuestTypeDTO>>> updateObject(@RequestBody ReservationRequestDTO reservationRequestDTO) {
        ResponseDTO responseDTO = new ResponseDTO(Boolean.TRUE, reservationService.updateObject(reservationRequestDTO));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<ResponseDTO<List<GuestTypeDTO>>> getAll() {
        ResponseDTO responseDTO = new ResponseDTO(Boolean.TRUE, reservationService.getAllObjects());
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDTO<ReservationRequestDTO>> getObjectById(@PathVariable long id) {
        ReservationRequestDTO reservationRequestDTO = reservationService.getObjectById(id);
        ResponseDTO responseDTO = new ResponseDTO(Boolean.TRUE, reservationRequestDTO);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

}
