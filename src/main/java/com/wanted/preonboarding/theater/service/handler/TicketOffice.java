package com.wanted.preonboarding.theater.service.handler;

import java.util.Arrays;
import java.util.List;

public class TicketOffice {
    private long amount;
    private final List<Ticket> tickets;

    public TicketOffice(Long amount, Ticket ... tickets) {
        this.amount = amount;
        this.tickets = Arrays.asList(tickets);
    }

    public TicketOffice(Long amount, List<Ticket> ticketList) {
        this.amount = amount;
        this.tickets = ticketList;
    }

    public Ticket publishTicket(int ticketId){
        return getTicket(ticketId);
    }

    public void increaseSalesAmount(long amount){
        plusAmount(amount);
    }

    // 티켓 리스트에서 ticketid 를 기준으로 한 조회
    public Ticket getTicket(int ticketId){
        var ticket = tickets.stream().filter(x -> x.getTicketId() == ticketId).findFirst();
        if (!ticket.isPresent()) return null;
        return ticket.get();

    }

    public void minusAmount(long amount) {
        this.amount -= amount;
    }
    public void plusAmount(long amount) {
        this.amount += amount;
    }
}
