package com.example.day3sms.repository;
import com.example.day3sms.model.StudentModel;
import com.example.day3sms.model.UserModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;

public interface UserRepository extends MongoRepository<UserModel , String> {

      Optional<StudentModel> findByEmail(String email);


}
