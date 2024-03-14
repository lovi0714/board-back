package com.study.rest.board.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;

import java.time.LocalDateTime;

@AllArgsConstructor
@Builder
public class RequestForAddBoard {
    private String writer;
    private String title;
    private String content;
    private LocalDateTime regDate;
}
