package com.project.hibernate.entity;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table
public class Message {
    @Id
    @GeneratedValue
    @Column(name = "message_id")
    private Integer id;

    private String body;

    @Temporal(TemporalType.TIMESTAMP)
    private Date created;

    private String senderId;

    private String receiverId;

    private String messageId;
}
