package com.example.skillsharevideorestservice.model;

import lombok.Data;
import lombok.NonNull;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.Date;

@Data
@Document(collection = "comments")
public class CommentModel {
    @MongoId(FieldType.OBJECT_ID)
    private String id;
    @NonNull
    private String videoId;
    @NonNull
    private String userId;
    @NonNull
    private String description;
    @CreatedDate
    private Date createdAt;
    @LastModifiedDate
    private Date updatedAt;
}