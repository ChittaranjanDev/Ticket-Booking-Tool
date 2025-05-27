package com.cloudbees.ticketbooking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.cloudbees.ticketbooking.dto.SeatChangeRequest;
import com.cloudbees.ticketbooking.model.Receipt;
import com.cloudbees.ticketbooking.model.Section;
import com.cloudbees.ticketbooking.model.User;
import com.cloudbees.ticketbooking.service.TicketService;

import java.util.List;

@RestController
@RequestMapping("/api/tickets")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @PostMapping
    public Receipt purchaseTicket(@RequestBody User user) {
        return ticketService.purchaseTicket(user);
    }

    @GetMapping("/{email}")
    public Receipt getReceipt(@PathVariable String email) {
        return ticketService.getReceipt(email);
    }

    @GetMapping("/section/{section}")
    public List<User> getUsersBySection(@PathVariable Section section) {
        return ticketService.getUsersBySection(section);
    }

    @DeleteMapping("/{email}")
    public String removeUser(@PathVariable String email) {
        return ticketService.removeUser(email) ? "User removed." : "User not found.";
    }

    @PutMapping("/{email}/seat")
    public Receipt modifySeat(@PathVariable String email, @RequestBody SeatChangeRequest request) {
        return ticketService.modifySeat(email, request.getNewSection());
    }
}
