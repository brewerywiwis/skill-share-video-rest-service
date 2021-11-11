package com.example.skillshareplaylistservice.controller;

import com.example.skillshareplaylistservice.model.PlaylistModel;
import com.example.skillshareplaylistservice.payload.CreatePlaylistRequest;
import com.example.skillshareplaylistservice.payload.DeletePlaylistRequest;
import com.example.skillshareplaylistservice.payload.EditPlaylistRequest;
import com.example.skillshareplaylistservice.service.PlaylistService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Data
@AllArgsConstructor
@RestController
@RequestMapping("/playlists")
public class PlaylistController {
    private final PlaylistService playlistService;

    @PostMapping("/playlist")
    public ResponseEntity<PlaylistModel> createPlaylist(@RequestBody CreatePlaylistRequest body) {
        PlaylistModel playlist = new PlaylistModel(body.getTitle(), body.getDescription(), body.getVideoList());
        return new ResponseEntity<>(playlistService.createPlaylist(playlist), HttpStatus.CREATED);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping()
    public List<PlaylistModel> getPlaylist(@Nullable @RequestParam String id, @Nullable @RequestParam String title) {
        if (id != null && !id.isBlank()) {
            return List.of(playlistService.getPlaylistById(id).orElseThrow());
        } else if (title != null && !title.isBlank()) {
            return playlistService.getPlaylistByTitle(title);
        }
        return playlistService.getAllPlaylist();
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PutMapping("/edit")
    public PlaylistModel editPlaylist(@RequestBody EditPlaylistRequest body) {
        PlaylistModel playlist = new PlaylistModel(body.getTitle(), body.getDescription(), body.getVideoList());
        playlist.setId(body.getId());
        return playlistService.editPlaylist(playlist);
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @DeleteMapping("/delete")
    public PlaylistModel deletePlaylist(@RequestParam String id) {
        return playlistService.deletePlaylist(id);
    }


}