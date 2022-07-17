package com.spring.practice.chap03.board.controller;

import com.spring.practice.chap03.board.repository.BoardRepository;
import com.spring.practice.chap03.board.repository.Post;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Log4j2
public class BoardService {


    private final BoardRepository repository;

    // 리스트 요청 중간 처리
    public List<Post> listService(){
        log.info("BoardService - list 요청!!");
        return repository.findAll();
    }

    // 게시글 상세보기 중간 처리
    public Post detailService(int boardNo){
        log.info("BoardService - detail 요청!!");
        return repository.findOne(boardNo);
    }

    // 새 글 쓰기 중간 처리
    public void writeService(Post post){
        log.info("BoardService - write 요청!!");
        repository.save(post);
    }

    // 게시글 삭제 중간 처리
    public boolean deleteService(int boardNo){
        log.info("BoardService - delete 요청!!");
        return repository.remove(boardNo);
    }

    // 게시글 수정 화면 요청 중간처리
    public Post modifyFormService(int boardNo){
        log.info("BoardService - modify Form 요청!!");
        return repository.findOne(boardNo);
    }

    // 게시글 수정 등록 요청 중간 처리
    public boolean modifyService(Post post){
        return repository.modify(post);
    }

}
