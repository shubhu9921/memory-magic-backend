package com.memorymagic.backend.repository;

import com.memorymagic.backend.entity.AppMetadata;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppMetadataRepository extends JpaRepository<AppMetadata, String> {
}

