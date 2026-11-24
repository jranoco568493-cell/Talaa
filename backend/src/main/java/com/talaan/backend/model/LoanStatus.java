// ==== PASTE INTO: backend/src/main/java/com/talaan/backend/model/LoanStatus.java
// ==== (this file also exists in my earlier zip. If you already have it, replace it with this one.
// ==== If you do not have it yet, it is a NEW file: right-click the model folder > New File, paste this)
package com.talaan.backend.model;

// Where a whole loan stands. It is worked out from the payments and today's date,
// so the service recalculates it instead of trusting an old saved value.
public enum LoanStatus {
    ONGOING("Ongoing"),
    OVERDUE("Overdue"),
    CLOSED("Closed");

    private final String displayName;

    LoanStatus(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}