package org.example.quiz2.service;

import lombok.RequiredArgsConstructor;
import org.example.quiz2.dto.BoardDTO;
import org.example.quiz2.entity.Boards;
import org.example.quiz2.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardServices {
    @Autowired
    private BoardRepository boardRepository;

    // 생성
    @Transactional
    public ResponseEntity<String> addUser(BoardDTO boardDTO) {
        if(!boardDTO.getEmail().contains("@")){
          return new ResponseEntity<>("noSave", HttpStatus.BAD_REQUEST);

        }
        Boards userEntity = boardDTO.toEntity();// 엔티티 변환
        boardRepository.save(userEntity);
        return new ResponseEntity<>("save", HttpStatus.OK);
    }

    // 조회
    public ResponseEntity<List<Boards>> userList() {
        boardRepository.findAll();

//        for (Users list : listUser) {
//
//        }

        return new ResponseEntity<>(HttpStatus.OK);
    };

    // 수정
    @Transactional
    public ResponseEntity<String> update(Long id, BoardDTO boardDTO){
        Boards users = boardRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디값이 없음.")
        );

//        users.update(userDTO.getName());
        String message = "성공";
        return new ResponseEntity<>("수정",HttpStatus.OK);
    }

    // 삭제
    @Transactional
    public ResponseEntity<String>  delete(Long id){
        Boards users = boardRepository.findById(id).orElse(null);
        boardRepository.delete(users);
        return new ResponseEntity<>("삭제",HttpStatus.OK);
    }



}
