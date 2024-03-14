package com.estsoft.blogjpa.controller;

import com.estsoft.blogjpa.model.Article;
import org.springframework.ui.Model;
import com.estsoft.blogjpa.dto.ArticleViewResponse;
import com.estsoft.blogjpa.service.BlogService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class BlogPageController {
    private BlogService blogService;
    public BlogPageController(BlogService blogService) {
        this.blogService = blogService;
    }

    @GetMapping("/articles")
    public String getArticles(Model model) {
        List<ArticleViewResponse> articles = blogService.findAll().stream()
                .map(ArticleViewResponse::new)
                .toList();
        model.addAttribute("articles", articles);

        return "articleList";
    }

    @GetMapping("/articles/{id}")
    public String showArticles(@PathVariable Long id, Model model) {
        Article article = blogService.findById(id);
        model.addAttribute("article", new ArticleViewResponse(article));
        return "article";
    }

    // id 키를 가진 queryParameter 값을 id변수에 매핑(id값이 없을 경우도 있음)
    @GetMapping("/new-article") // /new-articles?id={id} (수정) /new-articles (등록)
    public String newArticle(@RequestParam(required = false) Long id, Model model) {
        if (id == null) { // 등록
            model.addAttribute("article", new ArticleViewResponse());
        } else {
            Article article = blogService.findById(id);
            model.addAttribute("article", new ArticleViewResponse(article));
        }
        return "newArticle";
    }
}
