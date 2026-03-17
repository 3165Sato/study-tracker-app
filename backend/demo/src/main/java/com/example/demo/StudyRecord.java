package com.example.demo;

import java.time.Instant;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="StudyRecord", schema="exampledb")
public class StudyRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column()
    private String title;

    @Column()
    private Integer studyTime;

    @Column()
    private String category;

    @Column()
    private Instant createAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setStudyTime(Integer studyTime) {
        this.studyTime = studyTime;
    }

        public Integer getStudyTime() {
        return studyTime;
    }

    public void setCategory(String category) {
        this.category = category;
    }

        public String getCategory() {
        return category;
    }

    public void setCreateAt(Instant createAt) {
        this.createAt = createAt;
    }

        public Instant getcreateAt() {
        return createAt;
    }
}