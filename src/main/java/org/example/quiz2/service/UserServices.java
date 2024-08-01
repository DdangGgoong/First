package org.example.quiz2.service;

import lombok.RequiredArgsConstructor;
import org.example.quiz2.dto.UserDTO;
import org.example.quiz2.entity.Users;
import org.example.quiz2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServices {
    @Autowired
    private UserRepository userRepository;

    // 생성
    @Transactional
    public ResponseEntity<String> addUser(UserDTO userDTO) {
        if(!userDTO.getEmail().contains("@")){
          return new ResponseEntity<>("noSave", HttpStatus.BAD_REQUEST);

        }
        Users userEntity = userDTO.toEntity();// 엔티티 변환
        userRepository.save(userEntity);
        return new ResponseEntity<>("save", HttpStatus.OK);
    }

    // 조회
    public ResponseEntity<List<Users>> userList() {
        userRepository.findAll();

//        for (Users list : listUser) {
//
//        }

        return new ResponseEntity<>(HttpStatus.OK);
    };

    // 수정
    @Transactional
    public ResponseEntity<String> update(Long id, UserDTO userDTO){
        Users users = userRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디값이 없음.")
        );

//        users.update(userDTO.getName());
        String message = "성공";
        return new ResponseEntity<>("수정",HttpStatus.OK);
    }

    // 삭제
    @Transactional
    public ResponseEntity<String>  delete(Long id){
        Users users = userRepository.findById(id).orElse(null);
        userRepository.delete(users);
        return new ResponseEntity<>("삭제",HttpStatus.OK);
    }



}
