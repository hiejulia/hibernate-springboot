package com.project.hibernate.controller;

import java.util.List;

import com.project.hibernate.entity.Article;
import com.project.hibernate.service.IArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;

@Controller
@RequestMapping("/v1/api/articles")
public class ArticleController {

    @Autowired
    private IArticleService articleService;

    @GetMapping("/{id}")
    public ResponseEntity<Article> getArticleById(@PathVariable("id") Integer id) {
        Article article = articleService.getArticleById(id);
        return new ResponseEntity<Article>(article, HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<Article>> getAllArticles() {
        List<Article> list = articleService.getAllArticles();
        return new ResponseEntity<List<Article>>(list, HttpStatus.OK);
    }

    @GetMapping("/get5")
    public ResponseEntity<List<Article>> getAll5Articles() {
        List<Article> list = articleService.getAll5Articles();
        return new ResponseEntity<List<Article>>(list, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Article> addArticle(@Valid @RequestBody Article article) {
        System.out.print("create new article");
        System.out.print(article);
        if (article == null) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        articleService.addArticle(article);

        HttpHeaders headers = new HttpHeaders();
//        headers.setLocation(builder.path("/article/{id}").buildAndExpand(article.getArticleId()).toUri());
        return new ResponseEntity<Article>(headers, HttpStatus.CREATED);
    }
    @PutMapping
    public ResponseEntity<Article> updateArticle(@RequestBody Article article) {
        articleService.updateArticle(article);
        return new ResponseEntity<Article>(article, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteArticle(@PathVariable("id") Integer id) {
        articleService.deleteArticle(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}