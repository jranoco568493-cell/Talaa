package com.talaan.backend.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public record Installment(
		Long installmentId,
		Long loanId,
		LocalDate dueDate,
		BigDecimal amountDue,
		BigDecimal amountPaid,
		InstallmentStatus status) {
}
