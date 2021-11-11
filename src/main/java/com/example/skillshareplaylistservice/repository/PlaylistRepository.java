package com.example.skillshareplaylistservice.repository;


import com.example.skillshareplaylistservice.model.PlaylistModel;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PlaylistRepository extends MongoRepository<PlaylistModel, String> {
    List<PlaylistModel> findByTitleLike(String title);
}