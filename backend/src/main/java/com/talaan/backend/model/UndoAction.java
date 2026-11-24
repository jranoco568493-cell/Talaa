// ==== PASTE INTO: backend/src/main/java/com/talaan/backend/model/UndoAction.java
// ==== (NEW file: right-click the model folder > New File, name it exactly like this, then paste)
package com.talaan.backend.model;

import java.time.LocalDateTime;

// One entry in the Undo stack: a small note about what the lender just did,
// so the service can reverse it. It lives in memory only and is not saved in the database.
public class UndoAction {
    private UndoActionType type;     // PAYMENT or ARCHIVE
    private Long borrowerId;         // the borrower affected (used when undoing an archive)
    private Long loanId;             // the loan affected
    private Long paymentId;          // the payment to remove (only for PAYMENT, otherwise null)
    private LocalDateTime createdAt;

    // Default Constructor
    public UndoAction() {}

    // Minimal Constructor (required fields for a new undo entry)
    public UndoAction(UndoActionType type, Long borrowerId, Long loanId, Long paymentId) {
        this.type = type;
        this.borrowerId = borrowerId;
        this.loanId = loanId;
        this.paymentId = paymentId;
        this.createdAt = LocalDateTime.now();
    }

    // Full Constructor
    public UndoAction(UndoActionType type, Long borrowerId, Long loanId, Long paymentId,
                      LocalDateTime createdAt) {
        this.type = type;
        this.borrowerId = borrowerId;
        this.loanId = loanId;
        this.paymentId = paymentId;
        this.createdAt = createdAt;
    }

    // Getters and Setters
    public UndoActionType getType() {
        return type;
    }

    public void setType(UndoActionType type) {
        this.type = type;
    }

    public Long getBorrowerId() {
        return borrowerId;
    }

    public void setBorrowerId(Long borrowerId) {
        this.borrowerId = borrowerId;
    }

    public Long getLoanId() {
        return loanId;
    }

    public void setLoanId(Long loanId) {
        this.loanId = loanId;
    }

    public Long getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Long paymentId) {
        this.paymentId = paymentId;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}