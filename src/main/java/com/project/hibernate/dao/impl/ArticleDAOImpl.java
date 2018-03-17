package com.project.hibernate.dao.impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.project.hibernate.dao.IArticleDAO;
import com.project.hibernate.entity.Article;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
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
    public Article getArticleById(int articleId)  {
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

    // get all limit 10 using HQL
    @SuppressWarnings("unchecked")
    public List<Article> getAllArticles10() {
        Session session = sessionFactory.openSession();
        String hql = "FROM article as a order by a.created_at desc,a.title asc";
        Query query = session.createQuery(hql);
        List<Article> emList = query.list();
        return emList;
    }

    // SELECT ALL ARTICLE WITH THE SAME CREATED_DATE
    @SuppressWarnings("unchecked")
    public List<Article> getAllArticles10GroupByCreatedDate() {
        Session session = sessionFactory.openSession();
        String hql = "select count(a.title) from article a group by a.created_date";
        Query query = session.createQuery(hql);
        List<Article> emList = query.list();
        return emList;
    }

    // HQL - FIND ARTICLE BY CATEGORY - sql injection protection
    @SuppressWarnings("unchecked")
    public List<Article> getAllArticlesByCategory() {
        Session session = sessionFactory.openSession();
        String hql = "from article a where a.category =:categoryName";
        Query query = session.createQuery(hql);
        query.setParameter("categoryName","Work");
        List<Article> emList = query.list();
        return emList;
    }



    // SELECT QUERY WITH HQL
    @SuppressWarnings("unchecked")
    public List<Article> getAllArticlesByCustomQuery() {
        Session session = sessionFactory.openSession();
        String hql = "select a.title,a.content,a.description,a.category from article as a";
        Query query = session.createQuery(hql);
        List<Article> emList = query.list();
        return emList;
    }

    // where clause
    @SuppressWarnings("unchecked")
    public List<Article> getAllArticlesByCustomQueryWithWhere() {
        Session session = sessionFactory.openSession();
        String hql = "from article a where a.title ='Urgent'";
        Query query = session.createQuery(hql);
        List<Article> emList = query.list();
        return emList;
    }



//    @Transactional(readOnly = false)
//    public void insertEmployee(Employee employee) {
//        Session session = sessionFactory.openSession();
//        session.save(employee);
//    }

    @Override
    @Transactional(readOnly = false)
    public void addArticle(Article article) {
//        entityManager.
        entityManager.merge(article);
//        entityManager.getTransaction().commit();
//        entityManager.close();

        // 2 nd way to save the object
        // Session session = this.sessionFactory.openSession();
//        Serializable userId = session.save(user);
//        session.flush();
        // 3rd way to save the object
//        Session session = this.sessionFactory.openSession();
//        session.beginTransaction();
//        Serializable userId = session.save(user);
//        session.getTransaction().commit();
//        session.close();

        // 4th way to save object  persiste
//        Session session = this.sessionFactory.openSession();
//        session.beginTransaction();
//        session.persist(user);
//        session.getTransaction().commit();
//        session.close();
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

//    @Override
//    public void update(User user) {
//        Session session = this.sessionFactory.openSession();
//        User persistentUser = (User) session.load(User.class, new
//                Integer(user.getId()));
//        Transaction tx = session.beginTransaction();
//        persistentUser.setFirstName(user.getFirstname());
//        persistentUser.setLastname(user.getLastname());
//        session.update(persistentUser);
//        tx.commit();
//    }

//    @Override
//    public void update(User user) {
//        Session session = this.sessionFactory.openSession();
//        Transaction tx1 = session.beginTransaction();
//        User persistentUser = (User) session.load(User.class, new
//                Integer(user.getId()));
//        tx1.commit();
//        Transaction tx2 = session.beginTransaction();
//        user.setEmail(persistentUser.getEmail());
//        user.setPassword(persistentUser.getPassword());
//        session.merge(user);
//        tx2.commit();
//    }