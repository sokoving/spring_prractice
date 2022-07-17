package com.spring.practice.chap03.board.controller;

import com.spring.practice.chap03.board.repository.Comment;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class CommentServiceTest {

    @Autowired
    CommentService service;

    @Test
    @DisplayName("DB에서 지정한 글의 댓글만 가져와야 한다")
    void commentListServiceTest(){
        int boardNo = 8;
        List<Comment> comments = service.listService(8);
        for (Comment c : comments) {
            System.out.println(c);
        }
    }


}