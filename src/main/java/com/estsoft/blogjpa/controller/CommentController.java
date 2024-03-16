package com.estsoft.blogjpa.controller;

import com.estsoft.blogjpa.dto.AddCommentRequest;
import com.estsoft.blogjpa.dto.CommentResponse;
import com.estsoft.blogjpa.model.Comment;
import com.estsoft.blogjpa.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentController {
    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    // POST
    @PostMapping("/comments/{article_id}") // 게시글의 댓글 생성
    public ResponseEntity<CommentResponse> add(@RequestBody AddCommentRequest request) {
        Comment comment = commentService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(comment.toResponse()); // json
    }

    // GET
    @RequestMapping(value = "/comments", method = RequestMethod.GET)
    public ResponseEntity<List<CommentResponse>> showArticle() {
        List<Comment> commentList = commentService.findAll();
        List<CommentResponse> commentResponseList = commentList.stream()
                .map(CommentResponse::new)
                .toList();
        return ResponseEntity.ok(commentResponseList);
    }

}
