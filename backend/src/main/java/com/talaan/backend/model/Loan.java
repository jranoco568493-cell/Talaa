package com.talaan.backend.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public record Loan(
		Long loanId,
		Long borrowerId,
		BigDecimal principal,
		BigDecimal interestRate,
		BigDecimal totalAmount,
		LocalDate loanDate,
		LocalDate dueDate,
		PaymentFrequency paymentFrequency,
		String status,
		int numPayments,
		boolean isArchived,
		LocalDateTime archivedAt) {
}
