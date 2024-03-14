package com.study.rest.board.mapper;

import com.study.rest.board.dto.Board;
import com.study.rest.board.dto.RequestForAdd;
import com.study.rest.board.dto.RequestForUpdate;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {

    List<Board> getBoardList();

    Board getBoard(Long boardId);

    void addBoard(RequestForAdd requestForAdd);

    void updateBoard(RequestForUpdate requestForUpdate);

    void deleteBoard(Long boardId);
}
