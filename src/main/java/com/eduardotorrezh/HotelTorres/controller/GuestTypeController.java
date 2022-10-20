package com.eduardotorrezh.HotelTorres.controller;

import com.eduardotorrezh.HotelTorres.dto.GuestTypeDTO;
import com.eduardotorrezh.HotelTorres.dto.response.ResponseDTO;
import com.eduardotorrezh.HotelTorres.service.GuestTypeService;
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
import java.util.Optional;

@RestController
@RequestMapping("guest-type")
public class GuestTypeController {

    @Autowired
    GuestTypeService guestTypeService;

    @PostMapping()
    public ResponseEntity<ResponseDTO<GuestTypeDTO>> create(@RequestBody GuestTypeDTO guestTypeDTO) {
        ResponseDTO responseDTO = new ResponseDTO(Boolean.TRUE, guestTypeService.createObject(guestTypeDTO));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @PutMapping()
    public ResponseEntity<ResponseDTO<List<GuestTypeDTO>>> updateObject(@RequestBody GuestTypeDTO guestTypeDTO) {
        ResponseDTO responseDTO = new ResponseDTO(Boolean.TRUE, guestTypeService.updateObject(guestTypeDTO));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<ResponseDTO<List<GuestTypeDTO>>> getAll() {
        ResponseDTO responseDTO = new ResponseDTO(Boolean.TRUE, guestTypeService.getAllObjects());
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDTO<List<GuestTypeDTO>>> getObjectById(@PathVariable long id) {
        Optional<GuestTypeDTO> guestTypeDTOOptional = guestTypeService.getObjectById(id);
        ResponseDTO responseDTO = new ResponseDTO(guestTypeDTOOptional.isPresent() ? Boolean.TRUE : Boolean.TRUE, guestTypeDTOOptional.get());
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

}
