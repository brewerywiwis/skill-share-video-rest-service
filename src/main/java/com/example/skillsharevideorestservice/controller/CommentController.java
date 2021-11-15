package com.example.skillsharevideorestservice.controller;

import com.example.skillsharevideorestservice.model.CommentModel;
import com.example.skillsharevideorestservice.model.PlaylistModel;
import com.example.skillsharevideorestservice.payload.CreateCommentRequest;
import com.example.skillsharevideorestservice.payload.CreatePlaylistRequest;
import com.example.skillsharevideorestservice.payload.EditCommentRequest;
import com.example.skillsharevideorestservice.service.CommentService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import javax.xml.stream.events.Comment;
import java.util.List;

@Data
@AllArgsConstructor
@RestController
@RequestMapping("/comments")
public class CommentController {
    private final CommentService commentService;

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<CommentModel> getComment(@Nullable @RequestParam String videoId, @Nullable @RequestParam String userId){
        return commentService.getComment(videoId, userId);
    }

    @PostMapping("/comment")
    @ResponseStatus(HttpStatus.CREATED)
    public CommentModel createComment(@RequestBody CreateCommentRequest body) {
        if (body.getVideoId().isBlank()){
            throw new RuntimeException("Please check request body");
        }
        if (body.getUserId().isBlank()){
            throw new RuntimeException("Please check request body");
        }
        if (body.getDescription().isBlank()){
            throw new RuntimeException("Please check request body");
        }
        CommentModel commentModel = new CommentModel(body.getVideoId(), body.getUserId(), body.getDescription());
        return commentService.createComment(commentModel);
    }

    @PutMapping("/edit")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public CommentModel editComment(@RequestBody EditCommentRequest body){
        if (body.getId().isBlank()){
            throw new RuntimeException("Please check request body");
        }
        if (body.getVideoId().isBlank()){
            throw new RuntimeException("Please check request body");
        }
        if (body.getUserId().isBlank()){
            throw new RuntimeException("Please check request body");
        }
        if (body.getDescription().isBlank()){
            throw new RuntimeException("Please check request body");
        }
        CommentModel commentModel = new CommentModel(body.getVideoId(), body.getUserId(), body.getDescription());
        commentModel.setId(body.getId());
        return commentService.updateComment(commentModel);
    }

    @DeleteMapping("/delete")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public CommentModel deleteComment(@RequestParam String commentId, @RequestParam String userId){
        return commentService.deleteComment(commentId, userId);
    }
}