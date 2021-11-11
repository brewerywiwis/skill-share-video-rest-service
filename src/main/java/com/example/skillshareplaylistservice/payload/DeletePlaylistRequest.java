package com.example.skillshareplaylistservice.payload;

import lombok.Data;
import lombok.NonNull;

@Data
public class DeletePlaylistRequest {
    @NonNull
    private String id;
}