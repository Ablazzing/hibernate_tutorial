package org.example.lesson6.homework;

import org.example.lesson6.homework.config.HibernateConfig;
import org.example.lesson6.homework.dao.InstDao;
import org.example.lesson6.homework.dto.CommentDto;
import org.example.lesson6.homework.dto.UserDto;
import org.example.lesson6.homework.dto.PostDto;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class Server {
    private InstDao instDao;
    private SessionFactory sessionFactory = HibernateConfig.createSessionFactory();

    public Server(InstDao instDao) {
        this.instDao = instDao;
    }

    public void createUsers(List<UserDto> userList) {
        try (Session session = sessionFactory.openSession()) {
            userList.forEach(
                    userDto -> instDao.createUser(userDto.getUsername(), userDto.getPassword(), session));

        }
    }

    public void createPost(List<PostDto> postDtoList) {
        try (Session session = sessionFactory.openSession()) {
            postDtoList.forEach(
                    postDto -> instDao.createPost(postDto.getUserId(), postDto.getText(), session));

        }
    }

    public void createComment(List<CommentDto> commentDtos) {
        try (Session session = sessionFactory.openSession()) {
            commentDtos.forEach(
                    commentDto -> instDao.createComment(commentDto.getUserId(),
                            commentDto.getPostId(), commentDto.getText(), session));

        }
    }
}
