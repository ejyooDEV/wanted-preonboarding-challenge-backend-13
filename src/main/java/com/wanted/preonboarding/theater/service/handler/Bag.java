package com.wanted.preonboarding.theater.service.handler;

public class Bag {
    private int audienceId; // 가방 주인 아이디
    private Long amount; // 돈의 양
    private final Invitation invitation; // 초대 정보 객체
    private Ticket ticket; // 관람 티켓

    public Bag(int audienceId, long amount, Invitation invitation, Ticket ticket) {
        this.audienceId = audienceId;
        this.amount = amount;
        this.invitation = invitation;
        this.ticket = ticket;
    }

    public Bag(int id, long amount) {
        this(null, amount);
    }

    public Bag(long amount) {
        this(null, amount);
    }

    public Long hold(Ticket ticket) {
        if (hasInvitation()) {
            setTicket(ticket);
            return 0L;
        } else {
            setTicket(ticket);
            minusAmount(ticket.getFee());
            return ticket.getFee();
        }
    }

    /**
     * 기본 생성자 (파라미터))
     * 
     * @param invitation 초대여부
     * @param amount     돈의 양
     */
    public Bag(Invitation invitation, long amount) {
        this.invitation = invitation;
        this.amount = amount;
    }

    public boolean hasInvitation() {
        return invitation != null;
    }
    public boolean hasTicket() {
        return ticket != null;
    }
    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }
    public void minusAmount(long amount) {
        this.amount -= amount;
    }
    public void plusAmount(long amount) {
        this.amount += amount;
    }
}
