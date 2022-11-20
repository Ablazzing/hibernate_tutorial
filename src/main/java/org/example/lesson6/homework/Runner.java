package org.example.lesson6.homework;

import org.example.lesson6.homework.dao.InstDao;
import org.example.lesson6.homework.dto.CommentDto;
import org.example.lesson6.homework.dto.PostDto;
import org.example.lesson6.homework.dto.UserDto;

import java.util.List;

public class Runner {

    public static void main(String[] args) throws InterruptedException {
        Server server = new Server(new InstDao());
        int index = 1;
        while (true) {
            List<UserDto> userDtos = List.of(new UserDto("Yuri" + index, "1234"),
                    new UserDto("Petr" + index, "1234"));
            List<PostDto> postDtos = List.of(new PostDto("text" + index, 1),
                    new PostDto("text" + index, 1));
            List<CommentDto> commentDtos = List.of(new CommentDto("text" + index, 1, 1),
                    new CommentDto("2text" + index, 2, 2));
            server.createUsers(userDtos);
            server.createPost(postDtos);
            server.createComment(commentDtos);
            Thread.sleep(3000);
            index++;
        }
    }
}
