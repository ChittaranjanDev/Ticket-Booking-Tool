package com.cloudbees.ticketbooking.dto;


import com.cloudbees.ticketbooking.model.Section;

import lombok.Data;

@Data
public class SeatChangeRequest {
    private Section newSection;
}
