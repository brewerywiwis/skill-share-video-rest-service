package com.example.skillshareplaylistservice.model;

import lombok.Data;
import lombok.NonNull;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.List;

@Data
@Document(collection = "playlists")
public class PlaylistModel {
    @MongoId(FieldType.OBJECT_ID)
    private String id;
    @NonNull
    private String title;
    @NonNull
    private String description;
    @NonNull
    private List<String> videoList;
    @NonNull
    private String permission;
    @NonNull
    private String creatorId;
}