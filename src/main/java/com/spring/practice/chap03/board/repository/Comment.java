package com.spring.practice.chap03.board.repository;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

@Setter @Getter @ToString
public class Comment {

    private String commentContent;
    private String commentWriter;

    private int boardNo;
    private int commentNo;
    private Date commentRegDate;
    private int commentLikeCnt;

    public Comment(int boardNo, String commentContent, String commentWriter) {
        this.boardNo = boardNo;
        this.commentContent = commentContent;
        this.commentWriter = commentWriter;
    }

    public Comment(ResultSet rs) throws SQLException {
        this.commentContent = rs.getString("comment_content");
        this.commentWriter = rs.getString("comment_writer");
        this.boardNo = rs.getInt("board_no");
        this.commentNo = rs.getInt("comment_no");
        this.commentRegDate = rs.getDate("comment_reg_date");
        this.commentLikeCnt = rs.getInt("comment_like_cnt");
    }

}
