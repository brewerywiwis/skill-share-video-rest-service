package com.example.skillshareplaylistservice.payload;

import com.example.skillshareplaylistservice.model.VideoModel;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import java.util.List;

@Data
public class CreatePlaylistRequest {
    private String title;
    private String description;
    private List<String> videoList;
}