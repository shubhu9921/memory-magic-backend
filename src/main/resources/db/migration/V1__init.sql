-- Memory Magic Initial Database Migration
-- Version: V1__init.sql
-- Description: Sets up the initial schema for Memory Magic foundation

CREATE TABLE IF NOT EXISTS app_metadata (
    id VARCHAR(64) PRIMARY KEY,
    app_name VARCHAR(100) NOT NULL,
    version VARCHAR(20) NOT NULL,
    installed_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    status VARCHAR(20) NOT NULL DEFAULT 'ACTIVE'
);

INSERT INTO app_metadata (id, app_name, version, status)
SELECT 'meta_init', 'Memory Magic', '1.0.0', 'ACTIVE'
WHERE NOT EXISTS (SELECT 1 FROM app_metadata WHERE id = 'meta_init');
