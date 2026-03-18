package com.example.demo.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.StudyRecord;
import com.example.demo.api.dto.StudyRecordRequestDto;
import com.example.demo.api.dto.StudyRecordResponseDto;
import com.example.demo.api.service.StudyRecordService;
import com.example.demo.repositories.StudyRecordRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class StudyRecordController {
    
    @Autowired
    private StudyRecordService studyRecordService;

    @Autowired
    StudyRecordRepository repository;

    @GetMapping("/records")
    public List<StudyRecord> getRecords() {
        return repository.findAll();
    }

    @PostMapping("/records")
    public StudyRecordResponseDto createRecord(@RequestBody StudyRecordRequestDto request) {
        System.out.println("title=" + request.getTitle());
        System.out.println("category=" + request.getCategory());
        System.out.println("studyTime=" + request.getStudyTime());
        return studyRecordService.createRecord(request);
    }

}
