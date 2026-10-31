package com.memorymagic.backend.service;

import com.memorymagic.backend.dto.AppInfoResponse;
import com.memorymagic.backend.service.impl.AppInfoServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AppInfoServiceTest {

    @Test
    @DisplayName("AppInfoService should return configured application metadata")
    void shouldReturnConfiguredAppInfo() {
        AppInfoService service = new AppInfoServiceImpl("Memory Magic", "1.0.0", "staging");

        AppInfoResponse response = service.getAppInfo();

        assertThat(response).isNotNull();
        assertThat(response.isSuccess()).isTrue();
        assertThat(response.getApplication()).isEqualTo("Memory Magic");
        assertThat(response.getVersion()).isEqualTo("1.0.0");
        assertThat(response.getEnvironment()).isEqualTo("staging");
    }
}

