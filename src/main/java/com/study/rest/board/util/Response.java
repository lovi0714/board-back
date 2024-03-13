package com.study.rest.board.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Response {
    private String message;
    private Object data;

    public Response(String message) {
        this.message = message;
    }

}
