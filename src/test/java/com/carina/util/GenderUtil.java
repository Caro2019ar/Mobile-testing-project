package com.carina.util;

public enum GenderUtil {
    MALE("Male"), FEMALE("Female"), OTHER("Other");
    private final String gender;

    GenderUtil(String providedGender) {
        this.gender = providedGender;
    }
    public String getGender() {
        return this.gender;
    }

}