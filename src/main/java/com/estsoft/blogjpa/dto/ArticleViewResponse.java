package com.estsoft.blogjpa.dto;

import com.estsoft.blogjpa.domain.Article;

import java.time.LocalDateTime;

public class ArticleViewResponse {
    private Long id;
    private String title;
    private String content;
    private LocalDateTime createAt;

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getCreatedAt() {
        return createAt;
    }

    public ArticleViewResponse(Article article) {
        this.id = article.getId();
        this.title = article.getTitle();
        this.content = article.getContent();
        this.createAt = article.getCreatedAt();
    }

    public ArticleViewResponse() {
    }
}
