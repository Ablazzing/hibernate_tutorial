package org.example.lesson6.homework.dao;

import org.example.lesson6.homework.entity.Comment;
import org.example.lesson6.homework.entity.Post;
import org.example.lesson6.homework.entity.User;
import org.hibernate.Session;

public class InstDao {
    public void createUser(String username, String password, Session session) {
        session.beginTransaction();
        User user = new User(username, password);
        session.save(user);
        session.flush();
        session.getTransaction().commit();
    }

    public void createPost(Integer userId, String text, Session session) {
        session.beginTransaction();
        User user = session.get(User.class, userId);
        Post post = new Post(text, user);
        session.save(post);
        session.flush();
        session.getTransaction().commit();
    }

    public void createComment(Integer userId,Integer postId, String text, Session session) {
        session.beginTransaction();
        User user = session.get(User.class, userId);
        Post post = session.get(Post.class, postId);
        Comment comment = new Comment(text, user, post);
        session.save(comment);
        session.flush();
        session.getTransaction().commit();
    }

}
