package com.spring.practice.chap03.board.repository;

import java.util.List;

public interface CommentRepository {

    // 코멘트 등록
    boolean save(Comment comment);

    // 특정 글의 코멘트 전체 보기
    List<Comment> findAll();

    // 특정 코멘트 하나 보기
    Comment findOne(int commentNo);

    // 코멘트 삭제
    boolean remove(int commentNo);

    // 코멘트 수정
    boolean modify(Comment comment);


}
