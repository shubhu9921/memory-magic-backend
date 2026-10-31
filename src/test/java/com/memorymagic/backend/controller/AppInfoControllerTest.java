package com.memorymagic.backend.controller;

import com.memorymagic.backend.dto.AppInfoResponse;
import com.memorymagic.backend.service.AppInfoService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(AppInfoController.class)
class AppInfoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AppInfoService appInfoService;

    @Test
    @DisplayName("GET /api/v1/app/info should return HTTP 200 with application details")
    void getAppInfoShouldReturnDetails() throws Exception {
        AppInfoResponse response = new AppInfoResponse(true, "Memory Magic", "1.0.0", "development");
        given(appInfoService.getAppInfo()).willReturn(response);

        mockMvc.perform(get("/api/v1/app/info")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.success").value(true))
                .andExpect(jsonPath("$.application").value("Memory Magic"))
                .andExpect(jsonPath("$.version").value("1.0.0"))
                .andExpect(jsonPath("$.environment").value("development"));
    }
}

