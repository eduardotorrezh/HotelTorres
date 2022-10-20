package com.eduardotorrezh.HotelTorres.dto.response;

import com.eduardotorrezh.HotelTorres.dto.HotelDTO;
import com.eduardotorrezh.HotelTorres.dto.RoomTypeDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RoomResposeDTO {
    @JsonProperty("id")
    Long id;

    @JsonProperty("name")
    String name;

    @JsonProperty("description")
    String description;

    @JsonProperty("floor")
    Integer floor;

    @JsonProperty("max_guest")
    Integer maxGuest;

    @JsonProperty("room_type")
    RoomTypeDTO roomTypeDTO;

    @JsonProperty("hotel")
    HotelDTO hotelDTO;


}
