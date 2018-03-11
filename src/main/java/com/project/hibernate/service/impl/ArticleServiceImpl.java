package com.project.hibernate.service.impl;

import java.util.List;

import com.project.hibernate.dao.IArticleDAO;
import com.project.hibernate.entity.Article;
import com.project.hibernate.service.IArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleServiceImpl implements IArticleService {

    @Autowired
    private IArticleDAO articleDAO;

    @Override
    public Article getArticleById(int articleId) {
        Article obj = articleDAO.getArticleById(articleId);
        return obj;
    }
    @Override
    public List<Article> getAllArticles(){
        return articleDAO.getAllArticles();
    }

    @Override
    public List<Article> getAll5Articles() {
        return articleDAO.getAll5Articles();
    }

    @Override
    public void addArticle(Article article){
//        if (articleDAO.articleExists(article.getTitle(), article.getCategory())) {
//            return false;
//        } else {
            articleDAO.addArticle(article);
//            return true;
//        }
    }
    @Override
    public void updateArticle(Article article) {
        articleDAO.updateArticle(article);
    }
    @Override
    public void deleteArticle(int articleId) {
        articleDAO.deleteArticle(articleId);
    }
}