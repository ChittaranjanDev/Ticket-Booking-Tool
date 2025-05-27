package com.cloudbees.ticketbooking;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.cloudbees.ticketbooking.model.Receipt;
import com.cloudbees.ticketbooking.model.Section;
import com.cloudbees.ticketbooking.model.User;
import com.cloudbees.ticketbooking.service.TicketService;

import static org.junit.jupiter.api.Assertions.*;

public class TicketServiceTest {

    private TicketService ticketService;

    @BeforeEach
    void setup() {
        ticketService = new TicketService();
    }

    @Test
    void testPurchaseTicket() {
        User user = new User("Alice", "Smith", "alice@example.com");
        Receipt receipt = ticketService.purchaseTicket(user);
        assertNotNull(receipt);
        assertEquals("London", receipt.getFrom());
        assertEquals("France", receipt.getTo());
    }

    @Test
    void testGetReceipt() {
        User user = new User("Bob", "Brown", "bob@example.com");
        ticketService.purchaseTicket(user);
        Receipt receipt = ticketService.getReceipt("bob@example.com");
        assertNotNull(receipt);
    }

    @Test
    void testRemoveUser() {
        User user = new User("Clara", "Jones", "clara@example.com");
        ticketService.purchaseTicket(user);
        assertTrue(ticketService.removeUser("clara@example.com"));
    }

    @Test
    void testModifySeat() {
        User user = new User("Dan", "White", "dan@example.com");
        ticketService.purchaseTicket(user);
        Receipt modified = ticketService.modifySeat("dan@example.com", Section.B);
        assertNotNull(modified);
        assertTrue(modified.getSeatNumber().startsWith("B"));
    }
}