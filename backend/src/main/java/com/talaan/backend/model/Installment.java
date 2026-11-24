// ==== PASTE INTO: backend/src/main/java/com/talaan/backend/model/Installment.java
// ==== (select everything in that file with Ctrl+A, then paste this whole file over it)
package com.talaan.backend.model;

import java.math.BigDecimal;
import java.time.LocalDate;

// One scheduled payment of a loan (for example "payment 3 of 5, due Nov 12").
// The service creates all installments of a loan when the loan is added.
public class Installment {
    private Long installmentId;           // null until the record is saved
    private Long loanId;                  // which loan this installment belongs to
    private LocalDate dueDate;
    private BigDecimal amountDue;         // the last installment can be different, it covers the rounding
    private BigDecimal amountPaid;        // total of the PaymentAllocations for this installment
    private InstallmentStatus status;
    private int installmentNumber;        // NEW: 1, 2, 3 ... in order, so "payment 3 of 5" is easy to show

    // Default Constructor
    public Installment() {}

    // Minimal Constructor (required fields for a new installment)
    public Installment(Long loanId, int installmentNumber, LocalDate dueDate, BigDecimal amountDue) {
        this.loanId = loanId;
        this.installmentNumber = installmentNumber;
        this.dueDate = dueDate;
        this.amountDue = amountDue;
        this.amountPaid = BigDecimal.ZERO;
        this.status = InstallmentStatus.UNPAID;
    }

    // Full Constructor
    public Installment(Long installmentId, Long loanId, LocalDate dueDate, BigDecimal amountDue,
                       BigDecimal amountPaid, InstallmentStatus status, int installmentNumber) {
        this.installmentId = installmentId;
        this.loanId = loanId;
        this.dueDate = dueDate;
        this.amountDue = amountDue;
        this.amountPaid = amountPaid;
        this.status = status;
        this.installmentNumber = installmentNumber;
    }

    // Getters and Setters
    public Long getInstallmentId() {
        return installmentId;
    }

    public void setInstallmentId(Long installmentId) {
        this.installmentId = installmentId;
    }

    public Long getLoanId() {
        return loanId;
    }

    public void setLoanId(Long loanId) {
        this.loanId = loanId;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public BigDecimal getAmountDue() {
        return amountDue;
    }

    public void setAmountDue(BigDecimal amountDue) {
        this.amountDue = amountDue;
    }

    public BigDecimal getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(BigDecimal amountPaid) {
        this.amountPaid = amountPaid;
    }

    public InstallmentStatus getStatus() {
        return status;
    }

    public void setStatus(InstallmentStatus status) {
        this.status = status;
    }

    public int getInstallmentNumber() {
        return installmentNumber;
    }

    public void setInstallmentNumber(int installmentNumber) {
        this.installmentNumber = installmentNumber;
    }
}