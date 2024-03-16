package com.estsoft.blogjpa.dto;
import com.estsoft.blogjpa.model.Comment;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommentResponse {
    private Long id;
    private Long article_id;
    private String body;

    public CommentResponse(Comment comment) {
        body = comment.getBody();
    }
}
