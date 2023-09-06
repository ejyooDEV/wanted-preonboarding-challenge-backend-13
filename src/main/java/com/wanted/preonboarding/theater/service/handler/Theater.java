package com.wanted.preonboarding.theater.service.handler;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Theater {

    public boolean enter(Audience audience, TicketSeller ticketSeller, int ticketId) {
        long ticketFee = ticketSeller.sellTo(audience, ticketId);
        ticketSeller.receivePay(ticketFee);
        return true;
    }

    
}
