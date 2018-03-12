package com.project.hibernate.dao.impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.project.hibernate.dao.IArticleDAO;
import com.project.hibernate.entity.Article;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class ArticleDAOImpl implements IArticleDAO {

    @PersistenceContext
    private EntityManager entityManager;


    SessionFactory sessionFactory;

    Session session;

    Transaction transaction;


    @Override
    @Transactional(readOnly = true)
    public Article getArticleById(int articleId) {
        return entityManager.find(Article.class, articleId);
    }

    @SuppressWarnings("unchecked")
    @Override
    @Transactional(readOnly = true)
    public List<Article> getAllArticles() {
        String hql = "FROM Article as atcl ORDER BY atcl.articleId";
        return (List<Article>) entityManager.createQuery(hql).getResultList();
    }

    // GET TOP 5


    @Override
    @Transactional(readOnly = true)
    public List<Article> getAll5Articles() {
        return entityManager.createQuery("SELECT a FROM Article a ORDER BY a.articleId DESC").setMaxResults(5).getResultList();
    }

    @Override
    public void addArticle(Article article) {
//        entityManager.
        entityManager.merge(article);
//        entityManager.getTransaction().commit();
//        entityManager.close();

    }
    @Override
    public void updateArticle(Article article) {
        Article artcl = getArticleById(article.getArticleId());
        artcl.setTitle(article.getTitle());
        artcl.setCategory(article.getCategory());
        entityManager.flush();
    }
    @Override
    public void deleteArticle(int articleId) {
        entityManager.remove(getArticleById(articleId));
    }
    @Override
    public boolean articleExists(String title, String category) {
        String hql = "FROM Article as atcl WHERE atcl.title = ? and atcl.category = ?";
        int count = entityManager.createQuery(hql).setParameter(1, title)
                .setParameter(2, category).getResultList().size();
        return count > 0 ? true : false;
    }
}