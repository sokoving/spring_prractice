package com.spring.practice.chap03.board.repository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BoardRepositoryImpTest {

    @Autowired
    BoardRepository repository;

    @Test
    @DisplayName("포스트가 DB 테이블에 삽입돼야 함")
    @Transactional
    @Rollback
    void saveTest(){
        Post p = new Post("11", "111", "11111");
        boolean result = repository.save(p);
        assertTrue(result);
    }

    @Test
    @DisplayName("전체 포스트가 DB에서 조회되어야 한다")
    void findAllTest(){
        List<Post> all = repository.findAll();
        for (Post post : all) {
            System.out.println(post);
        }
    }

    @Test
    @DisplayName("특정 포스트가 DB에서 조회되어야 한다")
    void findOne(){
        Post one = repository.findOne(2);
        System.out.println(one);
    }

    @Test
    @DisplayName("특정 포스트가 DB에서 삭제되야 한다")
    @Transactional
    @Rollback
    void removeTest(){
        int boardNo = 2;
        boolean result = repository.remove(boardNo);
        assertTrue(result);
    }


    @Test
    @DisplayName("특정 포스트가 DB에서 수정되야 한다")
//    @Transactional
//    @Rollback
    void modifyTest(){
        Post one = repository.findOne(6);
        one.setTitle("mm");
        one.setWriter("MM");
        one.setContent("mm");
        boolean result = repository.modify(one);
        assertTrue(result);
    }

}