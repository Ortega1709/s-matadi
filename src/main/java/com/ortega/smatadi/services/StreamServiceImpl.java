package com.ortega.smatadi.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import static com.ortega.smatadi.utils.Constant.SONG_EXTENSION;
import static com.ortega.smatadi.utils.Constant.SONG_FORMAT;


@Slf4j
@Service
public class StreamServiceImpl implements StreamService {

    @Autowired
    @Qualifier("webApplicationContext")
    private ResourceLoader resourceLoader;


    @Override
    public Mono<Resource> getSong(String link) {
        log.info("Stream song {}", link);
        return Mono.fromSupplier(() -> resourceLoader.getResource(String.format(SONG_FORMAT, link + SONG_EXTENSION)));
    }

}
