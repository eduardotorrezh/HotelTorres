package com.eduardotorrezh.HotelTorres.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RoomTypeDTO {

    @JsonProperty("id")
    Long id;

    @JsonProperty("name")
    String name;

}
