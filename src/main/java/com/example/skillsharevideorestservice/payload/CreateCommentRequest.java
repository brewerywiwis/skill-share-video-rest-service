package com.example.skillsharevideorestservice.payload;

import lombok.Data;
import lombok.NonNull;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.Date;

@Data
public class CreateCommentRequest {
    @NonNull
    private String videoId;
    @NonNull
    private String userId;
    @NonNull
    private String description;
}
