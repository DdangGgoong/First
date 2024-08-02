package org.example.quiz2.cotroller;

import org.example.quiz2.dto.BoardDTO;
import org.example.quiz2.entity.Boards;
import org.example.quiz2.service.BoardServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private BoardServices boardServices;

    // 생성
    @PostMapping("/board")
    public ResponseEntity<String> addUser(BoardDTO boardDTO) {
//        if(userDTO.getEmail().contains("@")){
//            return userServices.addUser(userDTO);
//        }
//        else {
//            return userServices.noAddUser(userDTO);
//        }
        return boardServices.addUser(boardDTO);

    }

    // 삭제
    @PostMapping("/board/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {

        return boardServices.delete(id);
    }

    // 조회
    @GetMapping("/board")
    public ResponseEntity<List<Boards>> listUsers() {

        return  boardServices.userList();

    }

    // 수정
    @PutMapping("/board/{id}")
    public ResponseEntity<String> update(@PathVariable Long id, @RequestBody BoardDTO boardDTO) {

        return boardServices.update(id, boardDTO);


    }


    // 유저 리스트 R
    // 유저 U
    // 유저 D


}
