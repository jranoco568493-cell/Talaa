package com.talaan.backend.model;

import java.time.LocalDate;

public record Payment(
		String id,
		String loanId,
		LocalDate date,
		long amountCents,
		PaymentMethod method) {
}
