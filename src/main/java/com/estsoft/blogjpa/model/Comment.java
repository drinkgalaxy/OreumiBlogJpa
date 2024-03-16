package com.estsoft.blogjpa.model;

import com.estsoft.blogjpa.dto.CommentResponse;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@EntityListeners(AuditingEntityListener.class)
@Getter
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "article_id", nullable = false)
    private Long article_id;

    @Column(name = "body", nullable = false)
    private String body;

    @CreatedDate
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Builder
    public Comment(String body) {
        this.body = body;
    }

    public Comment() {
    }

    public Long getId() {
        return id;
    }

    public Long getArticle_id() {
        return article_id;
    }

    public String getBody() {
        return body;
    }

    public CommentResponse toResponse() {
        return CommentResponse.builder()
                .body(body)
                .build();
    }
}
