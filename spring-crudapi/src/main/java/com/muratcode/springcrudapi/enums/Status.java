package com.muratcode.springcrudapi.enums;

import lombok.Data;

import java.util.Objects;


public enum Status {

    ARRIVED(0, "Arrived"),
    DEPARTED(1, "Departed"),
    SCHEDULED(2, "Scheduled");


    private final  int code;
    private final  String value;
    Status(int code, String value) {
        this.code = code;
        this.value = value;
    }

    public int getCode() {
        return code;
    }

    public String getValue() {
        return value;
    }


    public static Status fromValue(String v) {
        for (Status p : Status.values()) {
            if (Objects.equals(p.value, v)) {
                return p;
            }
        }
        return null;
    }

    public static Status fromCode(int c) {
        for (Status e : Status.values()) {
            if (Objects.equals(e.code, c)) {
                return e;
            }
        }
        return null;
    }
}
