package com.eduardotorrezh.HotelTorres.controller;

import com.eduardotorrezh.HotelTorres.dto.RoomDTO;
import com.eduardotorrezh.HotelTorres.dto.request.RoomRequestDTO;
import com.eduardotorrezh.HotelTorres.dto.response.ResponseDTO;
import com.eduardotorrezh.HotelTorres.dto.response.RoomResposeDTO;
import com.eduardotorrezh.HotelTorres.service.RoomService;
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
@RequestMapping("room")
public class RoomController {

    @Autowired
    RoomService roomService;

    @PostMapping()
    ResponseEntity<ResponseDTO<RoomDTO>> create(@RequestBody RoomDTO roomDTO) throws Exception {
        ResponseDTO responseDTO = new ResponseDTO(Boolean.TRUE, roomService.createObject(roomDTO));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @PutMapping()
    ResponseEntity<ResponseDTO<RoomResposeDTO>> update(@RequestBody RoomRequestDTO roomRequestDTO) throws Exception {
        ResponseDTO responseDTO = new ResponseDTO(Boolean.TRUE, roomService.updateObject(roomRequestDTO));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @GetMapping
    ResponseEntity<ResponseDTO<List<RoomDTO>>> getAllObjects() {
        ResponseDTO responseDTO = new ResponseDTO(Boolean.TRUE, roomService.getAll());
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("hotel/{id}")
    ResponseEntity<ResponseDTO<List<RoomDTO>>> getAllObjectsByHotel(@PathVariable long id) throws Exception {
        ResponseDTO responseDTO = new ResponseDTO(Boolean.TRUE, roomService.getAllByHotelId(id));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    ResponseEntity<ResponseDTO<RoomDTO>> getObjectById(@PathVariable long id) throws Exception {
        RoomDTO roomDTO = roomService.getObjectById(id);
        ResponseDTO responseDTO = new ResponseDTO(Boolean.TRUE, roomDTO);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<ResponseDTO<String>> deleteObjectById(@PathVariable long id) throws Exception {
        roomService.deleteObjectById(id);
        ResponseDTO responseDTO = new ResponseDTO(Boolean.TRUE, "Delete successfully");
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

}
