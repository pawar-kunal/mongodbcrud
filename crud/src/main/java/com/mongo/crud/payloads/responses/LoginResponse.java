package com.mongo.crud.payloads.responses;

import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LoginResponse {

    private String studentId;

    private String name;

    private String email;

    private String mobile;

    private String address;

    private Date registrationDate;

    private String message;

    private Integer responseCode;

    private Boolean flag;
}
