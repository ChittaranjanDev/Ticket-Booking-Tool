package com.cloudbees.ticketbooking.service;


import org.springframework.stereotype.Service;

import com.cloudbees.ticketbooking.model.Receipt;
import com.cloudbees.ticketbooking.model.Section;
import com.cloudbees.ticketbooking.model.User;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class TicketService {

    private final Map<String, Receipt> ticketMap = new HashMap<>();
    private final Map<Section, AtomicInteger> seatCounters = Map.of(
        Section.A, new AtomicInteger(1),
        Section.B, new AtomicInteger(1)
    );

    public Receipt purchaseTicket(User user) {
        Section section = seatCounters.get(Section.A).get() <= seatCounters.get(Section.B).get() ? Section.A : Section.B;
        int seatNum = seatCounters.get(section).getAndIncrement();
        String seat = section.name() + seatNum;

        Receipt receipt = new Receipt("London", "France", user, 20, seat);
        ticketMap.put(user.getEmail(), receipt);
        return receipt;
    }

    public Receipt getReceipt(String email) {
        return ticketMap.get(email);
    }

    public List<User> getUsersBySection(Section section) {
        List<User> users = new ArrayList<>();
        for (Receipt r : ticketMap.values()) {
            if (r.getSeatNumber().startsWith(section.name())) {
                users.add(r.getUser());
            }
        }
        return users;
    }

    public boolean removeUser(String email) {
        return ticketMap.remove(email) != null;
    }

    public Receipt modifySeat(String email, Section newSection) {
        Receipt r = ticketMap.get(email);
        if (r != null) {
            int seatNum = seatCounters.get(newSection).getAndIncrement();
            r.setSeatNumber(newSection.name() + seatNum);
        }
        return r;
    }
}
