package com.example.skillsharevideorestservice.service;

import com.example.skillsharevideorestservice.model.CommentModel;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CommentService {
    List<CommentModel> getComment(String videoId, String userId);
    CommentModel createComment(CommentModel commentModel);
    CommentModel updateComment(CommentModel commentModel);
    CommentModel deleteComment(String commentId, String userId);

}


