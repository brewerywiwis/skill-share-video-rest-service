package com.example.skillsharevideorestservice.repository;

import com.example.skillsharevideorestservice.model.VideoModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface VideoRepository extends MongoRepository<VideoModel, String> {
}