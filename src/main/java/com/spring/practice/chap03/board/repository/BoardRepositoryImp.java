package com.spring.practice.chap03.board.repository;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
@Log4j2
public class BoardRepositoryImp implements BoardRepository{

    private final JdbcTemplate template;

    @Override
    public boolean save(Post post) {
        log.info("BoardRepositoryImp - save 요청!!");
        String sql = "INSERT INTO board (board_no, writer, title, content) VALUES (seq_board.nextval, ?, ?, ?)";
        return template.update(sql, post.getWriter(), post.getTitle(), post.getContent()) == 1;
    }

    @Override
    public List<Post> findAll() {
        log.info("BoardRepositoryImp - findAll 요청!!");
        String sql = "SELECT * FROM board ORDER BY board_no DESC";
        return template.query(sql, (rs, rowNum) -> new Post(rs));
    }

    @Override
    public Post findOne(int boardNo) {
        log.info("BoardRepositoryImp - findOne 요청!!");
        String sql = "SELECT * FROM board WHERE board_no=?";
        return template.queryForObject(sql, (rs, rowNum) -> new Post(rs), boardNo);
    }

    @Override
    public boolean remove(int boardNo) {
        log.info("BoardRepositoryImp - remove 요청!!");
        String sql = "DELETE FROM board WHERE board_no = ?";
        return template.update(sql, boardNo) == 1;
    }

    @Override
    public boolean modify(Post post) {
        String sql = "UPDATE board SET writer = ?, title = ?, content = ? WHERE board_no = ?";
        return template.update(sql, post.getWriter(), post.getTitle(), post.getContent(), post.getBoardNo()) == 1;
    }
}
