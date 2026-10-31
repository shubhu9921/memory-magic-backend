package com.memorymagic.backend.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"success", "application", "version", "environment"})
public class AppInfoResponse {

    private boolean success;
    private String application;
    private String version;
    private String environment;

    public AppInfoResponse() {
    }

    public AppInfoResponse(boolean success, String application, String version, String environment) {
        this.success = success;
        this.application = application;
        this.version = version;
        this.environment = environment;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getApplication() {
        return application;
    }

    public void setApplication(String application) {
        this.application = application;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }
}
