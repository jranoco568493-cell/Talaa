// ==== PASTE INTO: backend/src/main/java/com/talaan/backend/model/InstallmentStatus.java
// ==== (select everything in that file with Ctrl+A, then paste this whole file over it)
package com.talaan.backend.model;

// Where one installment stands.
// There is no OVERDUE here on purpose: "overdue" changes every day, so it is worked out
// from the due date and today's date (due date is before today and status is not PAID).
public enum InstallmentStatus {
    UNPAID("Unpaid"),
    PARTIAL("Partial"),
    PAID("Paid"),
    VOID("Void");      // cancelled, for example when an installment is replaced

    private final String displayName;

    InstallmentStatus(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}