package com.example.skillsharevideorestservice.repository;


import com.example.skillsharevideorestservice.model.PlaylistModel;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PlaylistRepository extends MongoRepository<PlaylistModel, String> {
    List<PlaylistModel> findByTitleLike(String title);
    List<PlaylistModel> findByCreatorId(String creatorId);
}