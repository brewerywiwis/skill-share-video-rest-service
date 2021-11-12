package com.example.skillshareplaylistservice.model;

import lombok.Data;
import lombok.NonNull;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.Date;

@Data
@Document(collection = "raw_videos")
public class VideoModel {
    @MongoId(FieldType.OBJECT_ID)
    private String id;
    @NonNull
    @Field("video_id")
    private String videoId;
    @NonNull
    private String encoding;
    @NonNull
    private String mime_type;
    @NonNull
    private Long size;
    @NonNull
    private String creator;
    @NonNull
    private String title;
    @NonNull
    private String description;
    @NonNull
    private String status;
    @NonNull
    private String permission;
    @NonNull
    private Date created_at;
    @NonNull
    private Data updated_at;
}