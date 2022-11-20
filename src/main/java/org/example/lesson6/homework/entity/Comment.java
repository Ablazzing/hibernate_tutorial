package org.example.lesson6.homework.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

//1.3. Создать таблицу comment - поля id, text, post_id (не нулевой), user_id (не нулевой), created_at (дата время)
@Entity
@Table(name = "\"comment\"")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Comment {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    @NonNull
    private String text;


    @Column(name = "created_at")
    @CreationTimestamp
    private Timestamp createdAt;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @NonNull
    private User user;

    @ManyToOne
    @JoinColumn(name = "post_id")
    @NonNull
    private Post post;
}
