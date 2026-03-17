package com.example.demo.api.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudyRecordRequestDto {
    private String title;
    private Integer studyTime;
    private String category;
}
