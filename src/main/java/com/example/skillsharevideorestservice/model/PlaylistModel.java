package com.example.skillsharevideorestservice.model;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.Date;
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
    @CreatedDate
    private Date createdAt;
    @LastModifiedDate
    private Date updatedAt;
}