package com.study.rest.board.service;

import com.study.rest.board.dto.Board;
import com.study.rest.board.dto.RequestForAddBoard;
import com.study.rest.board.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardMapper boardMapper;

    public List<Board> getBoardList() {
        return boardMapper.getBoardList();
    }
    public void addBoard(RequestForAddBoard board) {
        boardMapper.addBoard(board);
    }
}
