package com.spring.practice.chap03.board.repository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CommentRepositoryImpTest {

    @Autowired
    CommentRepository repository;

    @Test
    @DisplayName("댓글이 DB 테이블에 삽입돼야 함")
    @Transactional
    @Rollback
    void saveTest(){

        int boardNo = 8;
        Comment c = new Comment(boardNo,"4141", "41");
        boolean result = repository.save(c);
        assertTrue(result);
    }

    @Test
    @DisplayName("전체 댓글이 DB에서 조회되어야 한다")
    void findAllTest(){
        List<Comment> all = repository.findAll();
        for (Comment c : all) {
            System.out.println(c);
        }
    }

    @Test
    @DisplayName("특정 코멘트가 DB에서 삭제되야 한다")
    @Transactional
    @Rollback
    void removeTest(){
        int commentNo = 4;
        boolean result = repository.remove(commentNo);
        assertTrue(result);
    }

    @Test
    @DisplayName("특정 코멘트가 DB에서 수정돼야 한다")
//    @Transactional
//    @Rollback
    void modifyTest(){

        Comment one = repository.findOne(6);
        one.setCommentWriter("66");
        one.setCommentContent("666");
        boolean result = repository.modify(one);
        assertTrue(result);
    }

}