package com.jethrojonson.serves.api;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
public class MainFake {

    @PostConstruct
    void init() {

    }

}
