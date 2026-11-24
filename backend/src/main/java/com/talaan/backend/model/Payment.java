// ==== PASTE INTO: backend/src/main/java/com/talaan/backend/model/Payment.java
// ==== (select everything in that file with Ctrl+A, then paste this whole file over it)
package com.talaan.backend.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

// Money received from a borrower for one loan. Partial and advance payments are allowed.
public class Payment {
    private Long paymentId;              // null until the record is saved
    private Long loanId;                 // which loan was paid
    private BigDecimal amount;
    private LocalDate paymentDate;       // the date the borrower paid (can be a past date)
    private PaymentMethod paymentMethod;
    private String remarks;              // optional note typed by the lender
    private BigDecimal balanceAfter;     // loan balance right after this payment (filled in by the service)
    private LocalDateTime createdAt;     // NEW: when it was recorded. Undo uses this to find the LAST payment,
                                         // because paymentDate can be back-dated

    // Default Constructor
    public Payment() {}

    // Minimal Constructor (required fields for a new payment)
    public Payment(Long loanId, BigDecimal amount, LocalDate paymentDate, PaymentMethod paymentMethod) {
        this.loanId = loanId;
        this.amount = amount;
        this.paymentDate = paymentDate;
        this.paymentMethod = paymentMethod;
        this.remarks = "";
        this.balanceAfter = null;              // the service sets this after it applies the payment
        this.createdAt = LocalDateTime.now();
    }

    // Full Constructor
    public Payment(Long paymentId, Long loanId, BigDecimal amount, LocalDate paymentDate,
                   PaymentMethod paymentMethod, String remarks, BigDecimal balanceAfter,
                   LocalDateTime createdAt) {
        this.paymentId = paymentId;
        this.loanId = loanId;
        this.amount = amount;
        this.paymentDate = paymentDate;
        this.paymentMethod = paymentMethod;
        this.remarks = remarks;
        this.balanceAfter = balanceAfter;
        this.createdAt = createdAt;
    }

    // Getters and Setters
    public Long getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Long paymentId) {
        this.paymentId = paymentId;
    }

    public Long getLoanId() {
        return loanId;
    }

    public void setLoanId(Long loanId) {
        this.loanId = loanId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public BigDecimal getBalanceAfter() {
        return balanceAfter;
    }

    public void setBalanceAfter(BigDecimal balanceAfter) {
        this.balanceAfter = balanceAfter;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}