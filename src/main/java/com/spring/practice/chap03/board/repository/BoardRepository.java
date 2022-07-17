package com.spring.practice.chap03.board.repository;

import java.util.List;

public interface BoardRepository {

    // 포스트 등록
    boolean save(Post post);

    // 전체 포스트 보기
    List<Post> findAll();

    // 특정 포스트 보기
    Post findOne(int boardNo);

    // 포스트 삭제
    boolean remove(int boardNo);

    // 포스트 수정
    boolean modify(Post post);

}
