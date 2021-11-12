package com.example.skillshareplaylistservice.service;

import com.example.skillshareplaylistservice.model.PlaylistModel;
import com.example.skillshareplaylistservice.model.VideoModel;
import com.example.skillshareplaylistservice.payload.EditPlaylistRequest;

import java.util.List;
import java.util.Optional;

public interface PlaylistService {
    List<PlaylistModel> getAllPlaylist();
    Optional<PlaylistModel> getPlaylistById(String playlistId);
    List<PlaylistModel> getPlaylistByTitle(String title);
    List<PlaylistModel> getPlaylistByCreatorId(String creatorId);

    PlaylistModel createPlaylist(PlaylistModel playlistModel);

    PlaylistModel editPlaylist(EditPlaylistRequest editPlaylistRequest);

    PlaylistModel deletePlaylist(String id, String userId);

}