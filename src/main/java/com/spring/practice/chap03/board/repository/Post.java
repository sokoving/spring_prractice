package com.spring.practice.chap03.board.repository;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

@Setter @Getter @ToString
public class Post {

    private String writer;
    private String title;
    private String content;

    private int boardNo;
    private int viewCnt;
    private Date regDate;

    public Post(String writer, String title, String content) {
        this.writer = writer;
        this.title = title;
        this.content = content;
    }

    public Post(ResultSet rs) throws SQLException {
        this.boardNo = rs.getInt("board_no");
        this.writer = rs.getString("writer");
        this.title = rs.getString("title");
        this.viewCnt = rs.getInt("view_cnt");
        this.regDate = rs.getDate("reg_date");
        this.content = rs.getString("content");
    }

}
