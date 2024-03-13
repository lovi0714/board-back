package com.study.rest.board.controller;

import com.study.rest.board.dto.Board;
import com.study.rest.board.service.BoardService;
import com.study.rest.board.util.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@CrossOrigin("http://localhost:3000")
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {

    private final BoardService boardService;

    // 조회
    @GetMapping("/list")
    public ResponseEntity<?> getBoardList() {

        List<Board> boardList = boardService.getBoardList();

        try {
            // 조회에 성공한 경우
            String successMessage = "게시글 목록 조회에 성공했습니다.";

            return ResponseEntity.ok()
                    .body(new Response(successMessage, boardList));
        } catch (Exception e) {
            // 조회에 실패한 경우
            String errorMessage = "게시글 목록 조회에 실패했습니다.";

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new Response(errorMessage));
        }
    }


    // 등록


    // 수정



    // 삭제

}

