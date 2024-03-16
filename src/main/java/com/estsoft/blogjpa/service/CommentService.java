package com.estsoft.blogjpa.service;

import com.estsoft.blogjpa.dto.AddCommentRequest;
import com.estsoft.blogjpa.model.Comment;
import com.estsoft.blogjpa.repository.CommentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public List<Comment> findAll() {
        return commentRepository.findAll();
    }

    public Comment save(AddCommentRequest request) {
        return commentRepository.save(request.toEntity());
    }
}
