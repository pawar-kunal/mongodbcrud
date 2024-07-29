package com.mongo.crud.payloads.responses;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProfileResponse {

    private String studentId;

    private String name;

    private String email;

    private String mobile;

    private String address;

}
