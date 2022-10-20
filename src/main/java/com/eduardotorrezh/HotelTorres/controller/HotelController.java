package com.eduardotorrezh.HotelTorres.controller;

import com.eduardotorrezh.HotelTorres.dto.HotelDTO;
import com.eduardotorrezh.HotelTorres.dto.RoomTypeDTO;
import com.eduardotorrezh.HotelTorres.dto.request.HotelRequestDTO;
import com.eduardotorrezh.HotelTorres.dto.response.HotelResponseDTO;
import com.eduardotorrezh.HotelTorres.dto.response.ResponseDTO;
import com.eduardotorrezh.HotelTorres.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("hotel")
public class HotelController {

    @Autowired
    HotelService hotelService;

    @PostMapping()
    ResponseEntity<ResponseDTO<HotelResponseDTO>> create(@RequestBody HotelRequestDTO hotelRequestDTO) {
        ResponseDTO responseDTO = new ResponseDTO(Boolean.TRUE, hotelService.createObject(hotelRequestDTO));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @PutMapping()
    ResponseEntity<ResponseDTO<RoomTypeDTO>> update(@RequestBody HotelDTO hotelDTO) {
        ResponseDTO responseDTO = new ResponseDTO(Boolean.TRUE, hotelService.updateObject(hotelDTO));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @GetMapping
    ResponseEntity<ResponseDTO<List<RoomTypeDTO>>> getAllObjects() {
        ResponseDTO responseDTO = new ResponseDTO(Boolean.TRUE, hotelService.getAll());
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    ResponseEntity<ResponseDTO<HotelResponseDTO>> getObjectById(@PathVariable long id) {
        HotelResponseDTO hotelResponseDTO = hotelService.getObjectById(id);
        ResponseDTO responseDTO = new ResponseDTO(Boolean.TRUE, hotelResponseDTO);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<ResponseDTO<HotelResponseDTO>> deleteObjectById(@PathVariable long id) throws Exception {
        hotelService.deleteObjectById(id);
        ResponseDTO responseDTO = new ResponseDTO(Boolean.TRUE, "Delete successfully");
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

}
