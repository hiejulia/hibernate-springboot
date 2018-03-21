package com.project.hibernate.entity;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Table
@Entity
public class Comment {

    @Id
    @GeneratedValue
    @Column(name = "comment_id")
    private int id;

    @Column
    private Long postId;

    @Column(length = 4096)
    private String content;

    @Column
    private String author;

    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;

}
