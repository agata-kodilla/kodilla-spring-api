package com.kodilla.spring.tasks.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TaskDto {
    private long id;
    private String title;
    private String content;
}
