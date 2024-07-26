package com.mongo.crud.payloads.requests;

import lombok.Data;

import java.util.Date;

@Data
public class RegistrationRequest {
    private String studentId;

    private String name;

    private String email;

    private String mobile;

    private String address;

    private String status;
}
