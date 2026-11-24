// ==== PASTE INTO: backend/src/main/java/com/talaan/backend/model/Borrower.java
// ==== (select everything in that file with Ctrl+A, then paste this whole file over it)
package com.talaan.backend.model;

import java.time.LocalDateTime;

// A person the lender lends to. One borrower can have many loans.
public class Borrower {
    private Long borrowerId;           // null until the record is saved
    private Long userId;               // the lender (User) who owns this borrower record
    private String fullName;
    private String contactNumber;
    private String address;
    private String barangay;
    private boolean isArchived;        // archived borrowers are hidden, never deleted
    private LocalDateTime createdAt;
    private LocalDateTime archivedAt;  // NEW: when it was archived (null while active)

    // Default Constructor
    public Borrower() {}

    // Minimal Constructor (required fields for a new borrower)
    public Borrower(Long userId, String fullName, String contactNumber, String barangay) {
        this.userId = userId;
        this.fullName = fullName;
        this.contactNumber = contactNumber;
        this.barangay = barangay;
        this.address = "";
        this.isArchived = false;
        this.createdAt = LocalDateTime.now();
    }

    // Full Constructor
    public Borrower(Long borrowerId, Long userId, String fullName, String contactNumber, String address,
                    String barangay, boolean isArchived, LocalDateTime createdAt, LocalDateTime archivedAt) {
        this.borrowerId = borrowerId;
        this.userId = userId;
        this.fullName = fullName;
        this.contactNumber = contactNumber;
        this.address = address;
        this.barangay = barangay;
        this.isArchived = isArchived;
        this.createdAt = createdAt;
        this.archivedAt = archivedAt;
    }

    // Getters and Setters
    public Long getBorrowerId() {
        return borrowerId;
    }

    public void setBorrowerId(Long borrowerId) {
        this.borrowerId = borrowerId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBarangay() {
        return barangay;
    }

    public void setBarangay(String barangay) {
        this.barangay = barangay;
    }

    public boolean isArchived() {
        return isArchived;
    }

    public void setArchived(boolean isArchived) {
        this.isArchived = isArchived;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getArchivedAt() {
        return archivedAt;
    }

    public void setArchivedAt(LocalDateTime archivedAt) {
        this.archivedAt = archivedAt;
    }
}