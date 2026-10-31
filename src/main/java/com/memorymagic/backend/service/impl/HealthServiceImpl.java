package com.memorymagic.backend.service.impl;

import com.memorymagic.backend.dto.HealthResponse;
import com.memorymagic.backend.service.HealthService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class HealthServiceImpl implements HealthService {

    private static final Logger log = LoggerFactory.getLogger(HealthServiceImpl.class);

    @Override
    public HealthResponse getHealthStatus() {
        log.debug("Checking application health status");
        return new HealthResponse(true, "Memory Magic backend is running", "UP");
    }
}

