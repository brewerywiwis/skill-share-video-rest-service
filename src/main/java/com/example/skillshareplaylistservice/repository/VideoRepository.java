package com.example.skillshareplaylistservice.repository;

import com.example.skillshareplaylistservice.model.VideoModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface VideoRepository extends MongoRepository<VideoModel, String> {
}