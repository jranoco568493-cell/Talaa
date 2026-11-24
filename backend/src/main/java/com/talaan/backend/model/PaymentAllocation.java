// ==== PASTE INTO: backend/src/main/java/com/talaan/backend/model/PaymentAllocation.java
// ==== (select everything in that file with Ctrl+A, then paste this whole file over it)
package com.talaan.backend.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

// Says how much of one payment went to one installment.
// A payment covers the OLDEST unpaid installment first, then the next one, and so on.
// So one payment can have several allocations, and one installment can receive several payments.
public class PaymentAllocation {
    private Long allocationId;            // null until the record is saved
    private Long paymentId;               // which payment the money came from
    private Long installmentId;           // which installment received it
    private BigDecimal amountAllocated;
    private LocalDateTime createdAt;

    // Default Constructor
    public PaymentAllocation() {}

    // Minimal Constructor (required fields for a new allocation)
    public PaymentAllocation(Long paymentId, Long installmentId, BigDecimal amountAllocated) {
        this.paymentId = paymentId;
        this.installmentId = installmentId;
        this.amountAllocated = amountAllocated;
        this.createdAt = LocalDateTime.now();
    }

    // Full Constructor
    public PaymentAllocation(Long allocationId, Long paymentId, Long installmentId,
                             BigDecimal amountAllocated, LocalDateTime createdAt) {
        this.allocationId = allocationId;
        this.paymentId = paymentId;
        this.installmentId = installmentId;
        this.amountAllocated = amountAllocated;
        this.createdAt = createdAt;
    }

    // Getters and Setters
    public Long getAllocationId() {
        return allocationId;
    }

    public void setAllocationId(Long allocationId) {
        this.allocationId = allocationId;
    }

    public Long getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Long paymentId) {
        this.paymentId = paymentId;
    }

    public Long getInstallmentId() {
        return installmentId;
    }

    public void setInstallmentId(Long installmentId) {
        this.installmentId = installmentId;
    }

    public BigDecimal getAmountAllocated() {
        return amountAllocated;
    }

    public void setAmountAllocated(BigDecimal amountAllocated) {
        this.amountAllocated = amountAllocated;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
