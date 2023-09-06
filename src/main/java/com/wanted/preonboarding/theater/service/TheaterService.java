package com.wanted.preonboarding.theater.service;

import com.wanted.preonboarding.theater.service.handler.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TheaterService {
    private final Theater theater;

    public boolean enter(int audienceId, int ticketId){
        TicketSeller ticketSeller = this.getTicketSeller();
        Audience audience = this.getAudience(audienceId);
        boolean enterTheaterResult = theater.enter(audience, ticketSeller, ticketId);
        
        return enterTheaterResult;
    }

    /**
     * 관람객을 획득하는 서비스
     * 
     * @param audienceId     관람객 아이디
     * @param audienceAmount 관람객 금액
     * @return 관람객 객체
     */
    public Audience getAudience(int audienceId) {
        var audience = SampleDatas.AUDIENCE_LIST.stream()
                .filter(x -> x.getId() == audienceId).findFirst();

        if (!audience.isPresent()) return null;
        return audience.get();
    }

    /**
     * 셀러를 획득하는 서비스
     * 
     * @return
     */
    public TicketSeller getTicketSeller() {
        var ticketList = SampleDatas.TICKET_LIST; // 극장 DB
        var amount = SampleDatas.SELLER_AMOUNT; // 극장 DB
        var ticketOffice = new TicketOffice(amount, ticketList);
        var ticketSeller = new TicketSeller(ticketOffice);

        return ticketSeller;
    }
}
