package com.memorymagic.backend.service.impl;

import com.memorymagic.backend.dto.AppInfoResponse;
import com.memorymagic.backend.service.AppInfoService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class AppInfoServiceImpl implements AppInfoService {

    private final String appName;
    private final String appVersion;
    private final String environment;

    public AppInfoServiceImpl(
            @Value("${app.name:Memory Magic}") String appName,
            @Value("${app.version:1.0.0}") String appVersion,
            @Value("${app.environment:development}") String environment) {
        this.appName = appName;
        this.appVersion = appVersion;
        this.environment = environment;
    }

    @Override
    public AppInfoResponse getAppInfo() {
        return new AppInfoResponse(true, appName, appVersion, environment);
    }
}
