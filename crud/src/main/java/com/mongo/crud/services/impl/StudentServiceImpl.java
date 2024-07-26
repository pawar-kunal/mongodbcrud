package com.mongo.crud.services.impl;

import com.mongo.crud.models.Student;
import com.mongo.crud.payloads.requests.RegistrationRequest;
import com.mongo.crud.payloads.responses.MainResponse;
import com.mongo.crud.repositories.StudentRepository;
import com.mongo.crud.services.StudentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public MainResponse registration(RegistrationRequest registrationRequest) {
        MainResponse mainResponse = new MainResponse();
        Student student = new Student();

        BeanUtils.copyProperties(registrationRequest,student);

        student.setRegistrationDate(new Date());
        try {
            this.studentRepository.save(student);
            mainResponse.setMessage("Student registered successfully.");
            mainResponse.setResponseCode(HttpStatus.OK.value());
            mainResponse.setFlag(true);
        }catch (Exception e){
            e.printStackTrace();
            mainResponse.setMessage("Something went wrong.");
            mainResponse.setResponseCode(HttpStatus.BAD_REQUEST.value());
            mainResponse.setFlag(false);
        }
        return mainResponse;
    }

    @Override
    public Student getById(String studentId) {
        Optional<Student> student = this.studentRepository.findById(studentId);

        if (student.isPresent()){
            return student.get();
        }else {
            return null;
        }
    }

    @Override
    public MainResponse update(RegistrationRequest registrationRequest) {
        MainResponse mainResponse = new MainResponse();

        Optional<Student> student = this.studentRepository.findById(registrationRequest.getStudentId());

        if (student.isPresent()){
            BeanUtils.copyProperties(registrationRequest,student.get());
            try {
                this.studentRepository.save(student.get());
                mainResponse.setMessage("Student updated successfully.");
                mainResponse.setResponseCode(HttpStatus.OK.value());
                mainResponse.setFlag(true);
            }catch (Exception e){
                e.printStackTrace();
                mainResponse.setMessage("Something went wrong. Student not update.");
                mainResponse.setResponseCode(HttpStatus.BAD_REQUEST.value());
                mainResponse.setFlag(false);
            }
        }else {
            mainResponse.setMessage("Student not found.");
            mainResponse.setResponseCode(HttpStatus.BAD_REQUEST.value());
            mainResponse.setFlag(false);
        }
        return mainResponse;
    }

    @Override
    public List<Student> getAll() {
        List<Student> students = this.studentRepository.findAll();
        return students;
    }

    @Override
    public MainResponse delete(String studentId) {
        MainResponse mainResponse = new MainResponse();

        Optional<Student> student = this.studentRepository.findById(studentId);

        if (student.isPresent()){
            this.studentRepository.deleteById(studentId);
            mainResponse.setMessage("Student deleted successfully.");
            mainResponse.setResponseCode(HttpStatus.OK.value());
            mainResponse.setFlag(true);
        }else {
            mainResponse.setMessage("Something went wrong. Student not found.");
            mainResponse.setResponseCode(HttpStatus.BAD_REQUEST.value());
            mainResponse.setFlag(false);
        }
        return mainResponse;
    }
}
