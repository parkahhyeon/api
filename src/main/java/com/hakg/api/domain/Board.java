package com.hakg.api.domain;

import lombok.Data;

@Data
public class Board {
    private int id;
    private String title;
    private String content;
    private String author;

}

