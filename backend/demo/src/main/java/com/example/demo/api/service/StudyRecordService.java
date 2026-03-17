package com.example.demo.api.service;

import org.springframework.stereotype.Service;

import com.example.demo.StudyRecord;
import com.example.demo.api.dto.StudyRecordRequestDto;
import com.example.demo.api.dto.StudyRecordResponseDto;
import com.example.demo.repositories.StudyRecordRepository;

@Service
public class StudyRecordService {

    private final StudyRecordRepository studyRecordRepository;

    public StudyRecordService(StudyRecordRepository studyRecordRepository) {
        this.studyRecordRepository = studyRecordRepository;
    }

    public StudyRecordResponseDto createRecord(StudyRecordRequestDto request) {
        StudyRecord record = new StudyRecord();
        record.setTitle(request.getTitle());
        record.setStudyTime(request.getStudyTime());
        record.setCategory(request.getCategory());
        StudyRecord savedRecord = studyRecordRepository.save(record);

        return new StudyRecordResponseDto(
            savedRecord.getId(),
            savedRecord.getTitle(),
            savedRecord.getStudyTime(),
            savedRecord.getCategory()
        );
    }
}
