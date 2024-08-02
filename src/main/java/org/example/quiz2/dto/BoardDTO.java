package org.example.quiz2.dto;

import lombok.Data;
import org.example.quiz2.entity.Boards;

import java.util.Date;

@Data
public class BoardDTO {
    private Long id;
    private String title;
    private String email;
    private String author;
    private Date date;




    public Boards toEntity() {
        return Boards.builder()
                .title(title)
                .content(email)
                .author(author)
                .date(date)
                .build();
    }


}
