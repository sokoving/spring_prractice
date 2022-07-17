package com.spring.practice.chap03.board.controller;

import com.spring.practice.chap03.board.repository.Comment;
import com.spring.practice.chap03.board.repository.Post;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@Log4j2
public class BoardController {


    private final BoardService bService;
    private final CommentService cService;

    // Post 목록 불러오는 요청 처리
    @GetMapping("/board/list")
    public String list(Model model) {
        log.info("/board/list GET 요청!");
        List<Post> postList = bService.listService();
        model.addAttribute("pl", postList);
        return "chap03/board-list";
    }

    // Post 상세 보기 요청
    @GetMapping("/board/content")
    public String detail(int boardNo, Model model) {
        log.info("/board/detail GET 요청!");
        Post post = bService.detailService(boardNo);
        List<Comment> commentList = cService.listService(boardNo);
        model.addAttribute("p", post);
        model.addAttribute("cl", commentList);
        return "chap03/board-detail";
    }

    // 게시글 쓰기 화면요청
    @GetMapping("/board/write")
    public String write() {
        log.info("/board/write GET 요청!");
        return "chap03/board-write";
    }


    // 게시글 등록요청
    @PostMapping("/board/write")
    public String write(String writer, String title, String content) {
        log.info("/board/write POST 요청! - {}, {}, {}", writer, title, content);
        Post newPost = new Post(writer, title, content);
        bService.writeService(newPost);
        return "redirect:/board/list";

    }

    // 게시글 삭제요청
    @GetMapping("/board/delete")
    public String delete(int boardNo) {
        log.info("/board/delete GET 요청! - {}", boardNo);
        bService.deleteService(boardNo);
        return "redirect:/board/list";
    }

    // 게시글 수정 화면 요청
    @GetMapping("/board/modify")
    public String modify(int boardNo, Model model) {
        log.info("/board/modify GET 요청! - {}", boardNo);
        Post post = bService.modifyFormService(boardNo);
        model.addAttribute("p", post);
        return "chap03/board-modify";
    }

    // 게시글 수정 요청
    @PostMapping("/board/modify")
    public String modify(int boardNo, String writer, String title, String content) {
        log.info("/board/modify POST 요청! - {}, {}", writer, content);
        Post post = new Post(writer, title, content);
        post.setBoardNo(boardNo);
        bService.modifyService(post);
        return "redirect:/board/list";
    }

    // 댓글 등록 요청
    @PostMapping("/comment/save")
    public String commentSave(int boardNo, String commentWriter, String commentContent){
        Comment newComment = new Comment(boardNo, commentContent, commentWriter);
        cService.saveService(newComment);
        return "redirect:/board/content?boardNo=" + boardNo;
    }


}
