package com.wanted.preonboarding.theater.service.handler;

public class Ticket {
    private Long fee;
    private int ticketId; // 티켓 아이디
    private String ticketName; // 티켓 이름

    public Ticket(Long fee) {
        this.fee = fee;
    }

    public Ticket(int ticketId, String ticketName, Long fee) {
        this.ticketId = ticketId;
        this.ticketName = ticketName;
        this.fee = fee;
    }

    public int getTicketId() {
        return ticketId;
    }

    public String getTicketName() {
        return ticketName;
    }

    public Long getFee() {
        return fee;
    }
}
