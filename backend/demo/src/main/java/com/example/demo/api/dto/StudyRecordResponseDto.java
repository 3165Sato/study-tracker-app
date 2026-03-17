package com.example.demo.api.dto;

public class StudyRecordResponseDto {
    private Long id;
    private String title;
    private Integer studyTime;
    private String category;

    public StudyRecordResponseDto(Long id, String title, Integer studyTime, String category) {
        this.id = id;
        this.title = title;
        this.studyTime = studyTime;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Integer getStudyTime() {
        return studyTime;
    }

    public String getCategory() {
        return category;
    }
}
