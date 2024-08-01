package org.example.quiz2.cotroller;

import org.apache.logging.log4j.message.Message;
import org.example.quiz2.dto.UserDTO;
import org.example.quiz2.entity.Users;
import org.example.quiz2.repository.UserRepository;
import org.example.quiz2.service.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserServices userServices;

    // 생성
    @PostMapping("/board")
    public ResponseEntity<String> addUser(UserDTO userDTO) {
//        if(userDTO.getEmail().contains("@")){
//            return userServices.addUser(userDTO);
//        }
//        else {
//            return userServices.noAddUser(userDTO);
//        }
        return userServices.addUser(userDTO);

    }

    // 삭제
    @PostMapping("/board/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {

        return userServices.delete(id);
    }

    // 조회
    @GetMapping("/board")
    public ResponseEntity<List<Users>> listUsers() {

        return  userServices.userList();

    }

    // 수정
    @PutMapping("/board/{id}")
    public ResponseEntity<String> update(@PathVariable Long id, @RequestBody UserDTO userDTO) {

        return userServices.update(id, userDTO);


    }


    // 유저 리스트 R
    // 유저 U
    // 유저 D


}
