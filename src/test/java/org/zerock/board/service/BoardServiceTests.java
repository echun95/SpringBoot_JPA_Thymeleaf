package org.zerock.board.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.zerock.board.dto.BoardDTO;
import org.zerock.board.dto.PageRequestDTO;
import org.zerock.board.dto.PageResultDTO;
import org.zerock.board.entity.Board;

import javax.transaction.Transactional;

@SpringBootTest
public class BoardServiceTests {
    @Autowired
    private BoardService boardService;


    public void testRegister(){
        BoardDTO dto = BoardDTO.builder().title("test").content("test..").writerEmail("user55@aaa.com").build();
        Long bno = boardService.register(dto);
    }

    public void testList(){
        PageRequestDTO pageRequestDTO = new PageRequestDTO();
        PageResultDTO<BoardDTO, Object[]> result = boardService.getList(pageRequestDTO);
        for(BoardDTO dto : result.getDtoList()){
            System.out.println(dto);
        }
    }

    public void testGet(){
        Long bno = 100l;
        BoardDTO boardDTO = boardService.get(bno);
        System.out.println(boardDTO);
    }


    public void testRemove(){
        Long bno = 1l;
        boardService.removeWithReplies(bno);
    }


    @Test
    public void testModify(){
        BoardDTO boardDTO = BoardDTO.builder().bno(5L).title("제목 변경").content("내용 변경").build();
        boardService.modify(boardDTO);
    }

}
