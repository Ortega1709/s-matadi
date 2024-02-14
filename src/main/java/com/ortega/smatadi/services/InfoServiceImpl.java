package com.ortega.smatadi.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class InfoServiceImpl implements InfoService {
    @Override
    public String getInfoServer() {
        log.info("Get server info ...");
        return "Server Gemena";
    }
}
