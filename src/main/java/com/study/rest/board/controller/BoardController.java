package com.study.rest.board.controller;

import com.study.rest.board.dto.Board;
import com.study.rest.board.dto.RequestForAdd;
import com.study.rest.board.dto.RequestForUpdate;
import com.study.rest.board.service.BoardService;
import com.study.rest.board.util.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin("http://localhost:3000")
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {

    private final BoardService boardService;

    // 조회
    @GetMapping("")
    public ResponseEntity<?> getBoardList() {

        List<Board> boardList = boardService.getBoardList();

        try {
            // 조회에 성공한 경우
            String successMessage = "게시글 목록 조회에 성공했습니다.";

            return ok(successMessage, boardList);
        } catch (Exception e) {
            // 조회에 실패한 경우
            String errorMessage = "게시글 목록 조회에 실패했습니다.";

            return error(errorMessage);
        }
    }

    @GetMapping("/{boardId}")
    public ResponseEntity<?> getBoard(@PathVariable("boardId") Long boardId) {

        Board board = boardService.getBoard(boardId);
        
        try {
            if(board == null) throw new NullPointerException();
            String successMessage = "해당 게시글 조회에 성공했습니다.";
            return ok(successMessage, board);
        } catch (Exception e) {
            String errorMessage = "해당 게시글 조회에 실패했습니다.";
            return error(errorMessage);
        }
    }

    // 등록
    @PostMapping("/add")
    public ResponseEntity<?> addBoard(@RequestBody RequestForAdd requestForAdd) {

        try {
            boardService.addBoard(requestForAdd);
            // 등록에 성공한 경우
            String successMessage = "게시글 등록을 성공했습니다.";
            return ok(successMessage);
        } catch (Exception e) {
            // 등록에 실패한 경우
            String errorMessage = "게시글 등록에 실패했습니다.";
            return error(errorMessage);
        }
    }

    // 수정
    @PatchMapping("/update")
    public ResponseEntity<?> updateBoard(@RequestBody RequestForUpdate requestForUpdate) {

        try {
            boardService.updateBoard(requestForUpdate);
            // 수정에 성공한 경우
            String successMessage = "게시글 수정을 성공했습니다.";
            return ok(successMessage);
        } catch (Exception e) {
            // 수정에 실패한 경우
            String errorMessage = "게시글 수정에 실패했습니다.";
            return error(errorMessage);
        }
    }

    // 삭제
    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteBoard(@RequestParam("boardId") Long boardId) {

        try {
            boardService.deleteBoard(boardId);
            // 삭제에 성공한 경우
            String successMessage = "게시글을 삭제했습니다.";
            return ok(successMessage);
        } catch (Exception e) {
            // 삭제에 실패한 경우
            String errorMessage = "게시글 삭제에 실패했습니다.";
            return error(errorMessage);
        }
    }

    private ResponseEntity<?> ok(String successMessage){
        return ResponseEntity.ok()
                .body(new Response(successMessage));
    }

    private ResponseEntity<?> ok(String successMessage, Object data){
        return ResponseEntity.ok()
                .body(new Response(successMessage, data));
    }

    private ResponseEntity<?> error(String errorMessage){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new Response(errorMessage));
    }

}

