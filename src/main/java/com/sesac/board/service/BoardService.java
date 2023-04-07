package com.sesac.board.service;

import com.sesac.board.entity.Board;
import com.sesac.board.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;
import java.util.UUID;

@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;

    // 글 작성
    public void write(Board board, MultipartFile file) throws Exception{

        String projectPath = System.getProperty("user.dir") + "\\src\\main\\resources\\static\\files"; //저장할 경로 지정

        UUID uuid = UUID.randomUUID();//식별자 (파일 이름에 붙일 랜덤 이름을 생성)

        String fileName = uuid + "_" + file.getOriginalFilename(); // 랜덤 이름을 파일 이름 앞에 붙이고 언더바뒤 파일이름

        File saveFile = new File(projectPath, fileName); // 파일을 생성해 줄 건데 projectPath에  name이란 이름으로 넣는다

        file.transferTo(saveFile);

        board.setFilename(fileName);
        board.setFilepath("/files/"+ fileName);

        boardRepository.save(board);

    }

    // 게시글 리스트 처리
    public Page<Board> boardList(Pageable pageable){
        return boardRepository.findAll(pageable);
    }

    // 게시글 검색
    public Page<Board> boardSearchList(String searchKeyword, Pageable pageable){
        return boardRepository.findByTitleContaining(searchKeyword, pageable);
    }

    // 특정 게시글 불러오기
    public Board boardView(Integer id) {
        return boardRepository.findById(id).get();
    }

    // 특정 게시글 삭제
    public void boardDelete(Integer id){
        boardRepository.deleteById(id);
    }
}
