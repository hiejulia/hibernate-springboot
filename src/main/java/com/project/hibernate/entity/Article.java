package com.project.hibernate.entity;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;


// Entity Article -> User(role) -> create Article
@Entity
@Data
@Table(name="article")
public class Article implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="article_id",nullable = false)
    private int articleId;

    @Column(name="title",nullable = false)
    private String title;

    @Column(name="category")
    private String category;

    @Column(name = "content",nullable = false)
    private String content;

    @Column(name = "description")
    private String description;


    @CreatedDate
    @Version
    @Column(name = "created_at")
    private Date createdAt;



}
