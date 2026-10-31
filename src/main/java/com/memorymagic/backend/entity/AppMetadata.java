package com.memorymagic.backend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.Instant;

@Entity
@Table(name = "app_metadata")
public class AppMetadata {

    @Id
    @Column(name = "id", length = 64, nullable = false)
    private String id;

    @Column(name = "app_name", length = 100, nullable = false)
    private String appName;

    @Column(name = "version", length = 20, nullable = false)
    private String version;

    @Column(name = "installed_at")
    private Instant installedAt;

    @Column(name = "status", length = 20, nullable = false)
    private String status;

    public AppMetadata() {
        this.installedAt = Instant.now();
    }

    public AppMetadata(String id, String appName, String version, String status) {
        this.id = id;
        this.appName = appName;
        this.version = version;
        this.status = status;
        this.installedAt = Instant.now();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Instant getInstalledAt() {
        return installedAt;
    }

    public void setInstalledAt(Instant installedAt) {
        this.installedAt = installedAt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

