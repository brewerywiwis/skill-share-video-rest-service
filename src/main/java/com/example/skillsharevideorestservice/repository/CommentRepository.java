package com.example.skillsharevideorestservice.repository;

import com.example.skillsharevideorestservice.model.CommentModel;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CommentRepository extends MongoRepository<CommentModel, String> {
    List<CommentModel> findAllByVideoIdAndUserId(String videoId, String userId);
    List<CommentModel> findAllByVideoId(String videoId);
    List<CommentModel> findAllByUserId(String userId);
    CommentModel findByIdAndVideoIdAndUserId(String id, String videoId, String userId);
}