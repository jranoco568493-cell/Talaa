// ==== PASTE INTO: backend/src/main/java/com/talaan/backend/model/PaymentFrequency.java
// ==== (select everything in that file with Ctrl+A, then paste this whole file over it)
package com.talaan.backend.model;

// How often the borrower pays
public enum PaymentFrequency {
    DAILY("Daily"),
    WEEKLY("Weekly"),
    FORTNIGHTLY("Every 15 days"),   // every 15 days, not every 14
    MONTHLY("Monthly");

    private final String displayName;

    PaymentFrequency(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}