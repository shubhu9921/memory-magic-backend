package com.memorymagic.backend.service;

import com.memorymagic.backend.dto.HealthResponse;
import com.memorymagic.backend.service.impl.HealthServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class HealthServiceTest {

    private HealthService healthService;

    @BeforeEach
    void setUp() {
        healthService = new HealthServiceImpl();
    }

    @Test
    @DisplayName("HealthService should return successful UP response")
    void shouldReturnHealthyStatus() {
        HealthResponse response = healthService.getHealthStatus();

        assertThat(response).isNotNull();
        assertThat(response.isSuccess()).isTrue();
        assertThat(response.getStatus()).isEqualTo("UP");
        assertThat(response.getMessage()).isEqualTo("Memory Magic backend is running");
    }
}
