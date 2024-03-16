package com.estsoft.blogjpa.dto;

import com.estsoft.blogjpa.model.Article;
import com.estsoft.blogjpa.model.Comment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@AllArgsConstructor
@Builder
public class AddCommentRequest {
    private String body;

    public Comment toEntity() { // 생성자를 사용해 객체 생성
        return Comment.builder()
                .body(body)
                .build();
    }
}
