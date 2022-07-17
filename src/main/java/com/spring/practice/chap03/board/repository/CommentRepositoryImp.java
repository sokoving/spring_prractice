package com.spring.practice.chap03.board.repository;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
@Log4j2
public class CommentRepositoryImp implements CommentRepository {

    private final JdbcTemplate template;

    @Override
    public boolean save(Comment comment) {
        log.info("CommentRepositoryImp - save 요청!");
        String sql = "INSERT INTO reply (board_no, comment_no, comment_content, comment_writer)  VALUES (?, seq_comment.nextval, ?, ?)";
        return template.update(sql, comment.getBoardNo(), comment.getCommentContent(), comment.getCommentWriter()) == 1;
    }

    @Override
    public List<Comment> findAll() {
        log.info("CommentRepositoryImp - findAll 요청!");
        String sql = "SELECT * FROM reply order by comment_no DESC";
        return template.query(sql, (rs, rowNum) -> new Comment(rs));
    }

    @Override
    public Comment findOne(int commentNo) {
        log.info("CommentRepositoryImp - findOne 요청!");
        String sql = "SELECT * FROM reply WHERE comment_no=?";
        return template.queryForObject(sql, (rs, rowNum) -> new Comment(rs), commentNo);
    }

    @Override
    public boolean remove(int commentNo) {
        log.info("CommentRepositoryImp - remove 요청!");
        String sql = "DELETE FROM reply WHERE comment_no = ?";
        return template.update(sql, commentNo) == 1;
    }

    @Override
    public boolean modify(Comment comment) {
        String sql = "UPDATE reply SET comment_writer = ?, comment_content = ? WHERE comment_no = ?";
        return template.update(sql, comment.getCommentWriter(), comment.getCommentContent(), comment.getCommentNo()) == 1;
    }
}
