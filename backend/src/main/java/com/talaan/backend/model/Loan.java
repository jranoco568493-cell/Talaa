// ==== PASTE INTO: backend/src/main/java/com/talaan/backend/model/Loan.java
// ==== (select everything in that file with Ctrl+A, then paste this whole file over it)
package com.talaan.backend.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

// One loan given to a borrower. A borrower can have more than one loan.
// Money is in pesos with 2 decimal places (BigDecimal, never double).
public class Loan {
    private Long loanId;                       // null until the record is saved
    private Long borrowerId;                   // which borrower owns this loan
    private BigDecimal principal;              // amount borrowed
    private BigDecimal interestRate;           // percent for the WHOLE loan: 12.50 means 12.5% flat (not per month)
    private BigDecimal totalAmount;            // principal + interest (filled in by the service, not typed in)
    private LocalDate loanDate;                // date of the FIRST installment; the loan math counts from this day
    private LocalDate dueDate;                 // due date of the LAST installment (filled in by the service)
    private PaymentFrequency paymentFrequency;
    private LoanStatus status;                 // CHANGED: was a String. Recalculated by the service, never typed in
    private int numPayments;                   // how many installments
    private boolean isArchived;                // archived loans stay in the totals but cannot be changed
    private LocalDateTime archivedAt;          // null while active

    // Default Constructor
    public Loan() {}

    // Minimal Constructor (required fields for a new loan)
    public Loan(Long borrowerId, BigDecimal principal, BigDecimal interestRate, LocalDate loanDate,
                PaymentFrequency paymentFrequency, int numPayments) {
        this.borrowerId = borrowerId;
        this.principal = principal;
        this.interestRate = interestRate;
        this.loanDate = loanDate;
        this.paymentFrequency = paymentFrequency;
        this.numPayments = numPayments;
        this.totalAmount = BigDecimal.ZERO;    // the service works this out with LoanCalculator
        this.dueDate = null;                   // the service works this out with LoanCalculator
        this.status = LoanStatus.ONGOING;
        this.isArchived = false;
    }

    // Full Constructor
    public Loan(Long loanId, Long borrowerId, BigDecimal principal, BigDecimal interestRate,
                BigDecimal totalAmount, LocalDate loanDate, LocalDate dueDate,
                PaymentFrequency paymentFrequency, LoanStatus status, int numPayments,
                boolean isArchived, LocalDateTime archivedAt) {
        this.loanId = loanId;
        this.borrowerId = borrowerId;
        this.principal = principal;
        this.interestRate = interestRate;
        this.totalAmount = totalAmount;
        this.loanDate = loanDate;
        this.dueDate = dueDate;
        this.paymentFrequency = paymentFrequency;
        this.status = status;
        this.numPayments = numPayments;
        this.isArchived = isArchived;
        this.archivedAt = archivedAt;
    }

    // Getters and Setters
    public Long getLoanId() {
        return loanId;
    }

    public void setLoanId(Long loanId) {
        this.loanId = loanId;
    }

    public Long getBorrowerId() {
        return borrowerId;
    }

    public void setBorrowerId(Long borrowerId) {
        this.borrowerId = borrowerId;
    }

    public BigDecimal getPrincipal() {
        return principal;
    }

    public void setPrincipal(BigDecimal principal) {
        this.principal = principal;
    }

    public BigDecimal getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(BigDecimal interestRate) {
        this.interestRate = interestRate;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public LocalDate getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(LocalDate loanDate) {
        this.loanDate = loanDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public PaymentFrequency getPaymentFrequency() {
        return paymentFrequency;
    }

    public void setPaymentFrequency(PaymentFrequency paymentFrequency) {
        this.paymentFrequency = paymentFrequency;
    }

    public LoanStatus getStatus() {
        return status;
    }

    public void setStatus(LoanStatus status) {
        this.status = status;
    }

    public int getNumPayments() {
        return numPayments;
    }

    public void setNumPayments(int numPayments) {
        this.numPayments = numPayments;
    }

    public boolean isArchived() {
        return isArchived;
    }

    public void setArchived(boolean isArchived) {
        this.isArchived = isArchived;
    }

    public LocalDateTime getArchivedAt() {
        return archivedAt;
    }

    public void setArchivedAt(LocalDateTime archivedAt) {
        this.archivedAt = archivedAt;
    }
}
