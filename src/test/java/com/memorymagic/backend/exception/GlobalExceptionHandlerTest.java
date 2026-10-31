package com.memorymagic.backend.exception;

import com.memorymagic.backend.dto.ErrorResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

class GlobalExceptionHandlerTest {

    private GlobalExceptionHandler exceptionHandler;
    private HttpServletRequest request;

    @BeforeEach
    void setUp() {
        exceptionHandler = new GlobalExceptionHandler();
        request = mock(HttpServletRequest.class);
        given(request.getRequestURI()).willReturn("/api/v1/test");
    }

    @Test
    @DisplayName("handleApiException should return corresponding HttpStatus and ErrorResponse")
    void shouldHandleApiException() {
        ApiException ex = new ApiException("Invalid operation", HttpStatus.BAD_REQUEST);

        ResponseEntity<ErrorResponse> response = exceptionHandler.handleApiException(ex, request);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody().isSuccess()).isFalse();
        assertThat(response.getBody().getMessage()).isEqualTo("Invalid operation");
        assertThat(response.getBody().getPath()).isEqualTo("/api/v1/test");
    }

    @Test
    @DisplayName("handleGeneralException should return 500 Internal Server Error")
    void shouldHandleGeneralException() {
        Exception ex = new RuntimeException("Unexpected crash");

        ResponseEntity<ErrorResponse> response = exceptionHandler.handleGeneralException(ex, request);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR);
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody().isSuccess()).isFalse();
        assertThat(response.getBody().getMessage()).isEqualTo("An unexpected error occurred. Please try again later.");
    }
}

