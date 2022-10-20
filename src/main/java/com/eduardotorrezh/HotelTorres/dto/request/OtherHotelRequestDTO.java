package com.eduardotorrezh.HotelTorres.dto.request;

import com.eduardotorrezh.HotelTorres.dto.RoomDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OtherHotelRequestDTO {

    @JsonProperty("hotel")
    Long id;

    @JsonProperty("rooms")
    List<RoomDTO> roomDTOList;

}
