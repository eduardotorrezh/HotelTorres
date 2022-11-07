package com.eduardotorrezh.HotelTorres.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReservationRequestDTO {

    @NotEmpty
    @JsonProperty("principalGuest")
    GuestDTO guestDTO;

    @JsonProperty("otherGuest")
    List<GuestDTO> guestDTOList;

    @NotEmpty
    @JsonProperty("room")
    RoomDTO roomDTO;

    @NotEmpty
    @JsonProperty("start_date")
    Date startDate;

    @NotEmpty
    @JsonProperty("end_date")
    Date endDate;

    @JsonProperty("check_in")
    Boolean checkIn;

    @JsonProperty("kids")
    int kids;

}
