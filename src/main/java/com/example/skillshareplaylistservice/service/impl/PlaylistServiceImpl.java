package com.example.skillshareplaylistservice.service.impl;

import com.example.skillshareplaylistservice.model.PlaylistModel;
import com.example.skillshareplaylistservice.model.VideoModel;
import com.example.skillshareplaylistservice.payload.EditPlaylistRequest;
import com.example.skillshareplaylistservice.repository.PlaylistRepository;
import com.example.skillshareplaylistservice.repository.VideoRepository;
import com.example.skillshareplaylistservice.service.PlaylistService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Data
@AllArgsConstructor
@Service
public class PlaylistServiceImpl implements PlaylistService {
    private final PlaylistRepository playlistRepository;
    private final VideoRepository videoRepository;

    @Override
    public List<PlaylistModel> getAllPlaylist() {
        return playlistRepository.findAll();
    }

    @Override
    public Optional<PlaylistModel> getPlaylistById(String playlistId) {
        return playlistRepository.findById(playlistId);
    }

    @Override
    public List<PlaylistModel> getPlaylistByTitle(String title) {
        return playlistRepository.findByTitleLike(title);
    }

    @Override
    public List<PlaylistModel> getPlaylistByCreatorId(String creatorId) {
        return playlistRepository.findByCreatorId(creatorId);
    }

    @Override
    public PlaylistModel createPlaylist(PlaylistModel playlistModel) {
        return playlistRepository.insert(playlistModel);
    }

    @Override
    public PlaylistModel editPlaylist(EditPlaylistRequest editPlaylistRequest) {
        Optional<PlaylistModel> playlist = playlistRepository.findById(editPlaylistRequest.getId());
        if (playlist.isEmpty()) {
            throw new RuntimeException("Playlist not found");
        }
        if (!playlist.get().getCreatorId().equals(editPlaylistRequest.getUserId())) {
            throw new RuntimeException("Cannot edit playlist");
        }
        PlaylistModel playlistModel = playlist.get();
        playlistModel.setDescription(editPlaylistRequest.getDescription());
        playlistModel.setTitle(editPlaylistRequest.getTitle());
        playlistModel.setPermission(editPlaylistRequest.getPermission());
        playlistModel.setVideoList(editPlaylistRequest.getVideoList());
        return playlistRepository.save(playlistModel);
    }

    @Override
    public PlaylistModel deletePlaylist(String id, String userId) {
        Optional<PlaylistModel> playlist = playlistRepository.findById(id);
        if (playlist.isEmpty()) {
            throw new RuntimeException("Playlist not found");
        }
        if (!playlist.get().getCreatorId().equals(userId)) {
            throw new RuntimeException("Cannot delete playlist");
        }
        playlistRepository.delete(playlist.get());
        return playlist.get();
    }
}