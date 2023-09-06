package com.wanted.preonboarding.theater.controller;

import com.wanted.preonboarding.cafe.service.CafeService;
import com.wanted.preonboarding.theater.service.TheaterService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/theater")
@RequiredArgsConstructor
public class TheaterController {
    private final TheaterService theaterService;

    @GetMapping("hello")
    public String welcomeMessage() {
        return "Welcome to The Wanted Theater";
    }

    @GetMapping("enter")
    public String enter(@RequestParam int audienceId, int ticketId) {
        if (audienceId <= 0) {
            return "잘못된 사용자입니다. 극장 입장을 할 수 없습니다.";
        }

        boolean enterTheaterResult = theaterService.enter(audienceId, ticketId);
        
        if (enterTheaterResult) return "Welcom to the wanted theater";
        else return "fail to the wanted theater";
    }
}
