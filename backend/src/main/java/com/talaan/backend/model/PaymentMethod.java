// ==== PASTE INTO: backend/src/main/java/com/talaan/backend/model/PaymentMethod.java
// ==== (select everything in that file with Ctrl+A, then paste this whole file over it)
package com.talaan.backend.model;

// How a payment was received
public enum PaymentMethod {
    CASH("Cash"),
    GCASH("GCash"),
    MAYA("Maya"),
    BANK("Bank transfer"),
    OTHER("Other");

    private final String displayName;

    PaymentMethod(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}