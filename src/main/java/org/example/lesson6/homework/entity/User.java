package org.example.lesson6.homework.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

//1.1. Создать таблицу user - поля id, name (уникальный, не нулевой), password (не нулевой), created_at (дата время)
@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Table(name = "\"user\"")
public class User {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true, nullable = false)
    @NonNull
    private String name;

    @Column(nullable = false)
    @NonNull
    private String password;

    @Column(name = "created_at")
    @CreationTimestamp
    private Timestamp createdAt;
}
