package org.example.lesson6.homework.dto;

import lombok.Value;

@Value
public class CommentDto {
    String text;
    Integer userId;
    Integer postId;
}
