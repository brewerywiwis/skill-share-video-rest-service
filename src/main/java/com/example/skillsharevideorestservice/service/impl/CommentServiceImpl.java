package com.example.skillsharevideorestservice.service.impl;

import com.example.skillsharevideorestservice.model.CommentModel;
import com.example.skillsharevideorestservice.repository.CommentRepository;
import com.example.skillsharevideorestservice.service.CommentService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Data
@AllArgsConstructor
@Service
public class CommentServiceImpl implements CommentService {
    private CommentRepository commentRepository;

    @Override
    public List<CommentModel> getComment(String videoId, String userId) {
        if (videoId == null || videoId.isBlank()){
            if (userId == null || userId.isBlank()){
                return commentRepository.findAll();
            }
            return commentRepository.findAllByUserId(userId);
        } else if (userId == null || userId.isBlank()){
            return commentRepository.findAllByVideoId(videoId);
        }
        return commentRepository.findAllByVideoIdAndUserId(videoId, userId);
    }

    @Override
    public CommentModel createComment(CommentModel commentModel) {
        return commentRepository.insert(commentModel);
    }

    @Override
    public CommentModel updateComment(CommentModel commentModel) {
        CommentModel found = commentRepository.findByIdAndVideoIdAndUserId(commentModel.getId(), commentModel.getVideoId(), commentModel.getUserId());
        if (found == null){
            throw new RuntimeException("Comment Id not found");
        }
        found.setDescription(commentModel.getDescription());
        return commentRepository.save(found);
    }

    @Override
    public CommentModel deleteComment(String commentId, String userId) {
        Optional<CommentModel> found = commentRepository.findById(commentId);
        if (found.isEmpty()){
            throw new RuntimeException("Comment Id not found");
        }
        if (!found.get().getUserId().equals(userId)){
            throw new RuntimeException("Delete operation is not permitted");
        }
        commentRepository.deleteById(commentId);
        return found.get();
    }
}
