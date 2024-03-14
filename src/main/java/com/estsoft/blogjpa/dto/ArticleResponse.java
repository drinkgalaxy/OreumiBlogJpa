package com.estsoft.blogjpa.dto;
import com.estsoft.blogjpa.model.Article;
import lombok.*;
import org.springframework.web.ErrorResponse;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ArticleResponse {
    private String title;
    private String content;
    private Long id;

    public ArticleResponse(Article article) {
        title = article.getTitle();
        content = article.getContent();
        id = article.getId();
    }
}
