package com.estsoft.blogjpa.controller;

import com.estsoft.blogjpa.model.Article;
import com.estsoft.blogjpa.dto.AddArticleRequest;
import com.estsoft.blogjpa.dto.ArticleResponse;
import com.estsoft.blogjpa.service.BlogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

import java.util.List;

@RestController
public class BlogController {
    private final BlogService blogService;

    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @PostMapping("/api/articles") // json {"title" : "제목", "content" : "내용"}
    public ResponseEntity<ArticleResponse> addArticle(@RequestBody AddArticleRequest request) {
        // @RequestBody로 AddArticleRequest를 받아와 request로 저장
        Article article = blogService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(article.toResponse()); // json
    }

    // @RequestMapping은 value와 method를 명시해주어야 함.
    @RequestMapping(value = "/api/articles", method = RequestMethod.GET)
    public ResponseEntity<List<ArticleResponse>> showArticle() {
        // findAll() 메소드를 호출한 다음 응답용 객체인 ArticleResponse로 파싱함
        List<Article> articleList = blogService.findAll();
        // Article -> ArticleResponse로 변환하는 로직에 스트림을 적용한 것
        List<ArticleResponse> responseList = articleList.stream()
                .map(ArticleResponse::new)
                .toList();
        return ResponseEntity.ok(responseList);
    }

    // 블로그 글 단건 상세조회 API 구현
    @GetMapping("/api/articles/{id}")
    public ResponseEntity<ArticleResponse> showOneArticle(@PathVariable Long id) {
        Article article = blogService.findById(id);
        return ResponseEntity.ok(article.toResponse());
    }

    // 삭제
    @DeleteMapping("/api/articles/{id}")
    // 여기서 Void로 반환값을 지정한 이유는 아무런 값도 return을 해주지 않기 때문
    public ResponseEntity<Void> deleteOneArticle(@PathVariable Long id) {
        blogService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    // 업데이트
    @PutMapping("api/articles/{id}")
    public ResponseEntity<Article> updateOneArticle(@PathVariable Long id,
                                                    @RequestBody AddArticleRequest request) {
        Article update = blogService.update(id, request);
//        Article update = blogService.updateTitle(id, request);
        return ResponseEntity.ok(update);
    }

}
