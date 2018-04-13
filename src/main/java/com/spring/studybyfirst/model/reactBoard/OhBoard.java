package com.spring.studybyfirst.model.reactBoard;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.spring.studybyfirst.model.JsonModel;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class OhBoard extends JsonModel{

    private Integer boardKey;
    private String title;
    private String content;
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
