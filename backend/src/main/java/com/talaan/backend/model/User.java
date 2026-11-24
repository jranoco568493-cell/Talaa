package com.talaan.backend.model;

import java.time.LocalDateTime;

// The lender who logs in. Only the lender can use the system, so there is no role.
public class User {
    private Long userId;                // null until the record is saved
    private String username;            // must be unique; 3-32 letters, numbers, . _ -
    private String passwordHash;        // NEVER the real password, only the hashed version
    private LocalDateTime createdAt;

    // Default Constructor
    public User() {}

    // Minimal Constructor (required fields for a new user)
    public User(String username, String passwordHash) {
        this.username = username;
        this.passwordHash = passwordHash;
        this.createdAt = LocalDateTime.now();
    }

    // Full Constructor
    public User(Long userId, String username, String passwordHash, LocalDateTime createdAt) {
        this.userId = userId;
        this.username = username;
        this.passwordHash = passwordHash;
        this.createdAt = createdAt;
    }

    // Getters and Setters
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}