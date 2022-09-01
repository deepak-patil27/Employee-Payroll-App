package com.bridgelabz.employeepayrollapp.dto;

import lombok.Data;

@Data
public class Responsedto {
    private String message;
    private Object data;

    public Responsedto(String message, Object data) {
        this.message = message;
        this.data = data;

    }
}
