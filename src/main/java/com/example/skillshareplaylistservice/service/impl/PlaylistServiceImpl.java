package com.example.skillshareplaylistservice.service.impl;

import com.example.skillshareplaylistservice.model.PlaylistModel;
import com.example.skillshareplaylistservice.model.VideoModel;
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
    public List<VideoModel> getVideoByPlaylistId(String playlistId) throws RuntimeException {
        Optional<PlaylistModel> playlist = playlistRepository.findById(playlistId);
        if (playlist.isEmpty()) {
            throw new RuntimeException("Playlist not found");
        }
        return (List<VideoModel>) videoRepository.findAllById(playlist.get().getVideoList());
    }

    @Override
    public PlaylistModel createPlaylist(PlaylistModel playlistModel) {
        return playlistRepository.insert(playlistModel);
    }

    @Override
    public PlaylistModel editPlaylist(PlaylistModel playlistModel) {
        Optional<PlaylistModel> playlist = playlistRepository.findById(playlistModel.getId());
        if (playlist.isEmpty()) {
            throw new RuntimeException("Playlist not found");
        }
        return playlistRepository.save(playlistModel);
    }

    @Override
    public PlaylistModel deletePlaylist(String id) {
        Optional<PlaylistModel> playlist = playlistRepository.findById(id);
        if (playlist.isEmpty()) {
            throw new RuntimeException("Playlist not found");
        }
        playlistRepository.delete(playlist.get());
        return playlist.get();
    }
}