package com.talaan.backend.model;

import java.time.LocalDateTime;

public record User(
		Long userId,
		String username,
		String passwordHash,
		String role,
		LocalDateTime createdAt) {
}
