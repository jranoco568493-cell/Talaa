// ==== PASTE INTO: backend/src/main/java/com/talaan/backend/model/UndoActionType.java
// ==== (NEW file: right-click the model folder > New File, name it exactly like this, then paste)
package com.talaan.backend.model;

// The two things the Undo button can reverse (as required in the proposal)
public enum UndoActionType {
    PAYMENT("Payment"),   // the last recorded payment
    ARCHIVE("Archive");   // the last archived borrower (we archive instead of deleting)

    private final String displayName;

    UndoActionType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}