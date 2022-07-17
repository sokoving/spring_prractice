package com.spring.practice.chap03.board.controller;

import com.spring.practice.chap03.board.repository.Comment;
import com.spring.practice.chap03.board.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Log4j2
public class CommentService {

    private final CommentRepository repository;

    // 댓글 리스트 불러오기 중간 처리
    public List<Comment> listService(int boardNo){
        List<Comment> all = repository.findAll();
        List<Comment> commentList = new LinkedList<>();
        for (Comment c : all) {
            if(c.getBoardNo() == boardNo){
            commentList.add(c);
            }
        }
        return commentList;
    }

    // 댓글 저장하기 중간 처리
    public boolean saveService(Comment comment){
        return repository.save(comment);
    }


}
