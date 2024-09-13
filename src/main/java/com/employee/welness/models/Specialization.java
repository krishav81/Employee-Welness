package com.employee.welness.models;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Specialization {
	 CARDIOLOGY("CARDIOLOGY"),
     DENTAL("DENTAL"),
     ORTHOPEDICS("ORTHOPEDICS"),
     PEDIATRICS(" PEDIATRICS"),
     GENERAL(" GENERAL");

    private final String value;

    Specialization(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    @JsonCreator
    public static Specialization fromValue(String value) {
        for (Specialization role : Specialization.values()) {
            if (role.getValue().equalsIgnoreCase(value)) {
                return role;
            }
        }
        throw new IllegalArgumentException("Invalid role value: " + value);
    }
}
