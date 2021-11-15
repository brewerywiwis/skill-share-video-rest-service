package com.example.skillsharevideorestservice.payload;

import lombok.Data;
import lombok.NonNull;

import java.util.List;

@Data
public class CreatePlaylistRequest {
    @NonNull
    private String title;
    @NonNull
    private String description;
    @NonNull
    private List<String> videoList;
    @NonNull
    private String permission;
    @NonNull
    private String userId;
}