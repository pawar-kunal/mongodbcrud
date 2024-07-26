package com.mongo.crud.controllers;

import com.mongo.crud.models.Student;
import com.mongo.crud.payloads.requests.RegistrationRequest;
import com.mongo.crud.payloads.responses.MainResponse;
import com.mongo.crud.services.StudentService;
import com.mongo.crud.services.impl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/registration")
    public ResponseEntity registration(@RequestBody RegistrationRequest registrationRequest){
        MainResponse mainResponse = this.studentService.registration(registrationRequest);
        if (mainResponse.getFlag().equals(Boolean.TRUE)){
            return new ResponseEntity(mainResponse, HttpStatus.OK);
        }else {
            return new ResponseEntity(mainResponse, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getbyid/{studentId}")
    public ResponseEntity getByid(@PathVariable("studentId") String studentId){
        Student student = this.studentService.getById(studentId);

        if (student!=null){
            return new ResponseEntity(student, HttpStatus.OK);
        }else {
            return new ResponseEntity(student, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update")
    public ResponseEntity update(@RequestBody RegistrationRequest registrationRequest){
        MainResponse mainResponse = this.studentService.update(registrationRequest);

        if (mainResponse.getFlag().equals(Boolean.TRUE)){
            return new ResponseEntity(mainResponse, HttpStatus.OK);
        }else {
            return new ResponseEntity(mainResponse, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getall")
    public ResponseEntity getAll(){
        List<Student> students = this.studentService.getAll();
        return new ResponseEntity(students, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{studentId}")
    public ResponseEntity delete(@PathVariable("studentId") String studentId){
        MainResponse mainResponse = this.studentService.delete(studentId);

        if (Boolean.TRUE.equals(mainResponse.getFlag())){
            return new ResponseEntity(mainResponse, HttpStatus.OK);
        }else {
            return new ResponseEntity(mainResponse, HttpStatus.BAD_REQUEST);
        }
    }
}
