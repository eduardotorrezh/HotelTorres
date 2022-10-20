package com.eduardotorrezh.HotelTorres.controller;

import com.eduardotorrezh.HotelTorres.dto.RoomTypeDTO;
import com.eduardotorrezh.HotelTorres.dto.response.ResponseDTO;
import com.eduardotorrezh.HotelTorres.service.RoomTypeService;
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
@RequestMapping("room-type")
public class RoomTypeController {

    @Autowired
    RoomTypeService roomTypeService;

    @PostMapping()
    ResponseEntity<ResponseDTO<RoomTypeDTO>> create(@RequestBody RoomTypeDTO roomTypeDTO) {
        ResponseDTO responseDTO = new ResponseDTO(Boolean.TRUE, roomTypeService.createObject(roomTypeDTO));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @PutMapping()
    ResponseEntity<ResponseDTO<RoomTypeDTO>> update(@RequestBody RoomTypeDTO roomTypeDTO) {
        ResponseDTO responseDTO = new ResponseDTO(Boolean.TRUE, roomTypeService.updateObject(roomTypeDTO));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @GetMapping
    ResponseEntity<ResponseDTO<List<RoomTypeDTO>>> getAllObjects() {
        ResponseDTO responseDTO = new ResponseDTO(Boolean.TRUE, roomTypeService.getAll());
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    ResponseEntity<ResponseDTO<RoomTypeDTO>> getObjectById(@PathVariable long id) {
        Optional<RoomTypeDTO> responseDTOOptional = roomTypeService.getObjectById(id);
        ResponseDTO responseDTO = new ResponseDTO(Boolean.TRUE, responseDTOOptional.isPresent()?responseDTOOptional.get():null);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

}
