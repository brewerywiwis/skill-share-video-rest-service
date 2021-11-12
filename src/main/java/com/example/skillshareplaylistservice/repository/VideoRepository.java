package com.example.skillshareplaylistservice.repository;

import com.example.skillshareplaylistservice.model.VideoModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface VideoRepository extends MongoRepository<VideoModel, String> {

    @Query("{_id :?0}")
    VideoModel findByVideoId(String id);
}