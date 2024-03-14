package com.study.rest.board.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class RequestForUpdate {
    private final Long boardId;
    private final String title;
    private final String content;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm", timezone = "Asia/Seoul")
    private final LocalDateTime updDate;

    @JsonCreator
    public RequestForUpdate(@JsonProperty("boardId") Long boardId,
                            @JsonProperty("title") String title,
                         @JsonProperty("content") String content) {
        this.boardId = boardId;
        this.title = title;
        this.content = content;
        this.updDate = LocalDateTime.now();;
    }
}
