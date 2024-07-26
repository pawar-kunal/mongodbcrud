package com.mongo.crud.models;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Student {

    @Id
    private String studentId;

    private String name;

    private String email;

    private String mobile;

    private String address;

    @CreatedDate
    private Date registrationDate;

    private String status;
}
