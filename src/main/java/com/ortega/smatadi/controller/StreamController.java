package com.ortega.smatadi.controller;

import com.ortega.smatadi.services.StreamService;
import lombok.AllArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import reactor.core.publisher.Mono;

@AllArgsConstructor
@RequestMapping("api/v1")
public class StreamController {

    private StreamService streamService;
    @GetMapping(value = "stream/songs", produces = "audio/mp3")
    public Mono<Resource> getSongByLink(@RequestParam("link") String link) {
        return streamService.getSong(link);
    }

}