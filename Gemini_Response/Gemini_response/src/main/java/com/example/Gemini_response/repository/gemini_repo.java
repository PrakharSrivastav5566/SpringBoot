package com.example.Gemini_response.repository;

import com.example.Gemini_response.model.gemini_model;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface gemini_repo extends MongoRepository<gemini_model,String> {

}
