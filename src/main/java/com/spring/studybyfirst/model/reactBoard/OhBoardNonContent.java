package com.spring.studybyfirst.model.reactBoard;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class OhBoardNonContent implements IBoard{
    private Integer boardKey;
    private String title;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm", timezone="GMT+09:00")
    private LocalDateTime regiDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm", timezone="GMT+09:00")
    private LocalDateTime updateDate;
    private String flag;
    private Integer memberKey;
    private String boardSubImg;
    private String codeKey;
    private Integer categoryKey;
    private Integer hits;
}
