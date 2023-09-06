package com.wanted.preonboarding.theater.service.handler;

public class TicketSeller {
    private final TicketOffice ticketOffice;

    public TicketSeller(TicketOffice ticketOffice){
        this.ticketOffice = ticketOffice;
    }

    public TicketOffice getTicketOffice(){
        return ticketOffice;
    }

    public long sellTo(Audience a, int ticketId) {
        return a.buy(ticketOffice.publishTicket(ticketId));
    }

    public void receivePay(long ticketFee){
        ticketOffice.increaseSalesAmount(ticketFee);

    }
}
