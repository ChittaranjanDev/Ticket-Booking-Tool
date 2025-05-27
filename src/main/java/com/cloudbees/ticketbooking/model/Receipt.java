package com.cloudbees.ticketbooking.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Receipt {
    private String from = "London";
    private String to = "France";
    private User user;
    private int pricePaid = 20;
    private String seatNumber;
}
