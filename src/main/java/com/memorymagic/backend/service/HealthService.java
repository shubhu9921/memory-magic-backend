package com.memorymagic.backend.service;

import com.memorymagic.backend.dto.HealthResponse;

public interface HealthService {
    HealthResponse getHealthStatus();
}
