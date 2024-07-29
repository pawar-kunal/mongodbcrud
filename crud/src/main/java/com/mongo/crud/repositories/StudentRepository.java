package com.mongo.crud.repositories;

import com.mongo.crud.models.Student;
import com.mongo.crud.payloads.responses.ProfileResponse;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends MongoRepository<Student, String> {
    Optional<Student> findByMobile(String mobile);

//    @Query("select new com.mongo.crud.payloads.responses.ProfileResponse(p.studentId,p.name,p.email,p.mobile,p.address) from Student as p where p.studentId=:studentId")
//    ProfileResponse profile(@Param("studentId") String studentId);
}
