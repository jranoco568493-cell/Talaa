package com.talaan.backend.model;

import java.time.LocalDateTime;

public record Borrower(
		Long borrowerId,
		Long userId,
		String fullName,
		String contactNumber,
		String address,
		String barangay,
		boolean isArchived,
		LocalDateTime createdAt) {
}
