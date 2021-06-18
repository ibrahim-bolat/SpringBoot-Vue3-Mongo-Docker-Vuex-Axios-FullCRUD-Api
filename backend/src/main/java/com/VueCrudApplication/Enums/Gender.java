package com.VueCrudApplication.Enums;

import java.util.Arrays;

public enum Gender {
    M("MALE"),
    F("FEMALE");

    private String text;
    private Gender(String text) {
        this.text = text;
    }
    public String getGenderText() {
        return text;
    }
    public static Gender fromString(String text) throws IllegalArgumentException{
        return Arrays.stream(Gender.values()).
                filter(gender -> gender.text.equals(text))
                .findFirst()
                .orElseThrow(()->new IllegalArgumentException("Bilinmeyen Değer:"+text));
    }
}

