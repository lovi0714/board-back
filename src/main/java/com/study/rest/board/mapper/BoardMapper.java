package com.study.rest.board.mapper;

import com.study.rest.board.dto.Board;
import com.study.rest.board.dto.RequestForAddBoard;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {

    List<Board> getBoardList();

    void addBoard(RequestForAddBoard board);
}
