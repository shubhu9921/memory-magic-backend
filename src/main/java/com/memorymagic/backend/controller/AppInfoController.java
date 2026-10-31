package com.memorymagic.backend.controller;

import com.memorymagic.backend.dto.AppInfoResponse;
import com.memorymagic.backend.service.AppInfoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/app")
public class AppInfoController {

    private final AppInfoService appInfoService;

    public AppInfoController(AppInfoService appInfoService) {
        this.appInfoService = appInfoService;
    }

    @GetMapping("/info")
    public ResponseEntity<AppInfoResponse> getAppInfo() {
        AppInfoResponse response = appInfoService.getAppInfo();
        return ResponseEntity.ok(response);
    }
}

