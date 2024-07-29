package com.mongo.crud.services;

import com.mongo.crud.models.Student;
import com.mongo.crud.payloads.requests.LoginRequest;
import com.mongo.crud.payloads.requests.RegistrationRequest;
import com.mongo.crud.payloads.responses.LoginResponse;
import com.mongo.crud.payloads.responses.MainResponse;
import com.mongo.crud.payloads.responses.ProfileResponse;

import java.util.List;

public interface StudentService {
    MainResponse registration(RegistrationRequest registrationRequest);

    Student getById(String studentId);

    MainResponse update(RegistrationRequest registrationRequest);

    List<Student> getAll();

    MainResponse delete(String studentId);

    LoginResponse login(LoginRequest loginRequest);

    ProfileResponse profile(String studentId);
}
