package com.study.rest.board.dto;

import lombok.Value;

import java.time.LocalDateTime;

@Value
public class Board {

    Long boardId;
    String writer;
    String title;
    String content;
    LocalDateTime regDate;
    LocalDateTime updDate;

}
