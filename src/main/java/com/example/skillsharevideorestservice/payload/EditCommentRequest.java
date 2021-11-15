package com.example.skillsharevideorestservice.payload;

import lombok.Data;
import lombok.NonNull;

import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Data
public class EditCommentRequest {
    @NonNull
    private String id;
    @NonNull
    private String videoId;
    @NonNull
    private String userId;
    @NonNull
    private String description;
}
