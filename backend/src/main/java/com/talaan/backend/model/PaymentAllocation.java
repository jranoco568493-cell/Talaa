package com.talaan.backend.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record PaymentAllocation(
		Long allocationId,
		Long paymentId,
		Long installmentId,
		BigDecimal amountAllocated,
		LocalDateTime createdAt) {
}
