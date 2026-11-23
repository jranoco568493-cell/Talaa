package com.talaan.backend.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public record Payment(
		Long paymentId,
		Long loanId,
		BigDecimal amount,
		LocalDate paymentDate,
		PaymentMethod paymentMethod,
		String remarks,
		BigDecimal balanceAfter) {
}
