package org.example.quiz2.dto;

import lombok.Data;
import org.example.quiz2.entity.Users;

import java.util.Date;

@Data
public class UserDTO {
    private Long id;
    private String title;
    private String email;
    private String author;
    private Date date;




    public Users toEntity() {
        return Users.builder()
                .title(title)
                .content(email)
                .author(author)
                .date(date)
                .build();
    }


}
