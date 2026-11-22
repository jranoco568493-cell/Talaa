package com.talaan.backend.model;

import java.time.LocalDate;

public record Loan(
		String id,
		String borrowerId,
		long principalCents,
		int interestRateBasisPoints,
		int installmentCount,
		PaymentFrequency frequency,
		LocalDate startDate,
		LocalDate archivedAt) {
}
