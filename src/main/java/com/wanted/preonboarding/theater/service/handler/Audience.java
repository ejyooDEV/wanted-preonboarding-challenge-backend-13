package com.wanted.preonboarding.theater.service.handler;

public class Audience {
    private int id; // 관람객 아이디
    private final Bag bag; // 관람객 가방

    public Audience(Bag bag){
        this.bag = bag;
    }
    public Audience(int id, Bag bag) {
        this.id = id;
        this.bag = bag;
    }
    
    public long buy(Ticket t){
        return bag.hold(t);
    }

    public Bag getBag() { return bag; }
    public int getId() { return id; }
}